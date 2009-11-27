package org.ffenn.validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.ffenn.vrml.DefStatement;
import org.ffenn.vrml.Field;
import org.ffenn.vrml.FieldDeclaration;
import org.ffenn.vrml.Node;
import org.ffenn.vrml.NodeBodyElement;
import org.ffenn.vrml.ProtoStatement;
import org.ffenn.vrml.RouteStatement;
import org.ffenn.vrml.Script;
import org.ffenn.vrml.impl.EventInImpl;
import org.ffenn.vrml.impl.EventOutImpl;
import org.ffenn.vrml.impl.ExposedFieldDeclarationImpl;
import org.ffenn.vrml.impl.ExposedFieldImpl;
import org.ffenn.vrml.impl.FieldDeclarationImpl;
import org.ffenn.vrml.impl.FieldImpl;

import com.google.inject.cglib.core.CollectionUtils;
import com.google.inject.cglib.core.Transformer;

public class VrmlJavaValidator extends AbstractVrmlJavaValidator {
	// Reference : http://blogs.itemis.de/stundzig/archives/487

	protected Map<String, ProtoDef> protoList = new HashMap<String, ProtoDef>();
	protected Map<String, ProtoDef> defList = new HashMap<String, ProtoDef>();

	/*
	 * Manage validation of Protos : - check duplicates name and fire an error
	 * if found - stores user defined Protos in a hashmap and checks if this
	 * Proto is already defined in another file (fire a warning if that's the
	 * case)
	 */
	@SuppressWarnings("unchecked")
	@Check(CheckType.NORMAL)
	public void duplicateProtoNames(ProtoStatement protoStatement) {
		EList<EObject> allSiblings = protoStatement.eContainer().eContents();
		List<ProtoStatement> typedSiblings = EcoreUtil2.typeSelect(allSiblings, ProtoStatement.class);
		List<String> names = (List<String>) CollectionUtils.transform(typedSiblings, new Transformer() {
			public String transform(final Object arg0) {
				return ((ProtoStatement) arg0).getName();
			}
		});
		int nameFrequency = Collections.frequency(names, protoStatement.getName());
		if (nameFrequency != 1) {
			error("Duplicate name " + protoStatement.getName(), org.ffenn.vrml.VrmlPackage.PROTO_STATEMENT__NAME);
		} else {
			ProtoDef proto = new ProtoDef(protoStatement.getName(), this);
			for (EObject o : protoStatement.eContents()) {
				storeField(proto, o);
			}
			protoList.put(protoStatement.getName(), proto);
			if (VrmlProtoDef.getAllFilesProtoList().containsKey(protoStatement.getName()) && !VrmlProtoDef.getAllFilesProtoList().get(protoStatement.getName()).isInTheSameFile(this)) {
				warning(protoStatement.getName() + " already exists in another file", 5);// org.ffenn.vrml.VrmlPackage.PROTO_STATEMENT__NAME);
			} else {
				VrmlProtoDef.getAllFilesProtoList().put(protoStatement.getName(), proto);
			}
			if (protoList.size() > names.size()) {
				syncProtoList(names);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkNodeFieldsValidity(NodeBodyElement nbe) {
		if (nbe.eContainer().eContainer() instanceof Node) {
			String fieldName = nbe.getFieldName(); // Nom du champ actuel
			// Nom du node dans lequel on se trouve
			String nodeName = ((Node) nbe.eContainer().eContainer()).getName();
			if (fieldName != null && nodeName != null) {
				if (protoList.containsKey(nodeName)) {
					ProtoDef protoDef = (ProtoDef) protoList.get(nodeName);
					if (!FieldValidator.validate(protoDef.getFieldType(fieldName), nbe.getFieldValue().getValue())) {
						error("Wrong value type for " + protoDef.getFieldType(fieldName), org.ffenn.vrml.VrmlPackage.NODE_BODY_ELEMENT);
					}
				} else if (VrmlProtoDef.getGrammarProtoList().containsKey(nodeName)) {
				}
				FType fieldType = VrmlProtoDef.getGrammarProtoList().get(nodeName).getFieldType(fieldName);
				if (!FieldValidator.validate(fieldType, nbe.getFieldValue().getValue())) {
					error("Wrong value type for " + fieldType, org.ffenn.vrml.VrmlPackage.NODE_BODY_ELEMENT);
				}
			}

		}
	}

	@Check(CheckType.FAST)
	public void checkFieldValidity(FieldDeclaration field) {
		// TODO Vérifier correspondances entre noeud IS noeud
		for (EObject f : field.eContents()) {
			if (f instanceof Field) {
				Field fi = (Field) f;
				if (!FieldValidator.validate(FType.valueOf(fi.getFType()), field.getValues().getValue())) {
					error("Wrong value type for " + fi.getFType(), org.ffenn.vrml.VrmlPackage.FIELD_DECLARATION);
				}
			}
		}
	}

	private void syncProtoList(List<String> names) {
		List<String> toDelete = new LinkedList<String>();

		for (String protoName : protoList.keySet()) {
			boolean isStillProto = false;
			for (String name : names) {
				if (name.equals(protoName)) {
					isStillProto = true;
					break;
				}
			}
			if (!isStillProto) {
				toDelete.add(protoName);
			}
		}

		for (String del : toDelete) {
			protoList.remove(del);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkDefStatement(DefStatement def) {
		String name = def.getName();
		ProtoDef proto = null;
		for (EObject d : def.eContents()) {
			if (d instanceof Node) {
				String nodeName = ((Node) d).getName();
				if (protoList.containsKey(nodeName)) {
					proto = protoList.get(nodeName);
				} else if (VrmlProtoDef.getGrammarProtoList().containsKey(nodeName)) {
					proto = VrmlProtoDef.getGrammarProtoList().get(nodeName);
				} else if (VrmlProtoDef.getAllFilesProtoList().containsKey(nodeName)) {
					proto = VrmlProtoDef.getAllFilesProtoList().get(nodeName);
					warning(proto.getName() + " is defined in another file, this may not work", org.ffenn.vrml.VrmlPackage.DEF_STATEMENT__NODE);
				} else {
					error("Proto " + nodeName + " is not defined", org.ffenn.vrml.VrmlPackage.DEF_STATEMENT__NODE);
				}
			} else if (d instanceof Script) {
				proto = new ProtoDef("Script", this);
				for (EObject sbody : d.eContents()) {
					for (EObject field : sbody.eContents()) {
						storeField(proto, field);
					}
				}
			}
			if (name != null && proto != null) {
				defList.put(name, proto);
			}
		}
	}

	private void storeField(ProtoDef proto, EObject object) {
		if (object instanceof FieldDeclarationImpl) {
			for (EObject f : object.eContents()) {
				if (f instanceof FieldImpl) {
					FieldImpl field = (FieldImpl) f;
					proto.addField(field.getName(), FieldType.FIELD, FType.valueOf(field.getFType()));
				}
			}
		} else if (object instanceof ExposedFieldDeclarationImpl) {
			for (EObject f : object.eContents()) {
				if (f instanceof ExposedFieldImpl) {
					ExposedFieldImpl field = (ExposedFieldImpl) f;
					proto.addField(field.getName(), FieldType.EXPOSED_FIELD, FType.valueOf(field.getFType()));
				}
			}
		} else if (object instanceof EventInImpl) {
			EventInImpl event = (EventInImpl) object;
			proto.addField(event.getName(), FieldType.EVENT_IN, FType.valueOf(event.getFType()));
		} else if (object instanceof EventOutImpl) {
			EventOutImpl event = (EventOutImpl) object;
			proto.addField(event.getName(), FieldType.EVENT_OUT, FType.valueOf(event.getFType()));
		}
	}

	@Check(CheckType.NORMAL)
	public void checkRouteStatement(RouteStatement route) {
		if (!defList.containsKey(route.getSource().getName())) {
			error(route.getSource().getName() + " is not defined", org.ffenn.vrml.VrmlPackage.ROUTE_STATEMENT__SOURCE);
		} else if (!defList.containsKey(route.getTarget().getName())) {
			error(route.getTarget().getName() + " is not defined", org.ffenn.vrml.VrmlPackage.ROUTE_STATEMENT__TARGET);
		} else if (!defList.get(route.getSource().getName()).isEventOut(route.getEventOut())) {
			error(route.getEventOut() + " is not an eventOut or exposedField", org.ffenn.vrml.VrmlPackage.ROUTE_STATEMENT__EVENT_OUT);
		} else if (!defList.get(route.getTarget().getName()).isEventIn(route.getEventIn())) {
			error(route.getEventIn() + " is not an eventIn", org.ffenn.vrml.VrmlPackage.ROUTE_STATEMENT__EVENT_IN);
		} else if (!defList.get(route.getTarget().getName()).getFieldType(route.getEventOut()).equals(defList.get(route.getSource().getName()).getFieldType(route.getEventIn()))) {
			error(route.getEventIn() + " is not of the same type that is " + route.getEventOut() + " (" + defList.get(route.getTarget().getName()).getFieldType(route.getEventOut()) + ")", org.ffenn.vrml.VrmlPackage.ROUTE_STATEMENT__EVENT_IN);
		}
	}

}
