package org.ffenn.validation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  Stores the informations (name, types and values of the fields) of each proto.
 */
public class ProtoDef {
	private Map<String, FieldDef> fieldList = new HashMap<String, FieldDef>();
	private String name = null;
	private VrmlJavaValidator file = null;
	
	public ProtoDef(String name, VrmlJavaValidator file) {
		this.name = name;
		this.file = file;
	}
	
	public ProtoDef(String name) {
		this.name = name;
	}
	
	public boolean isInTheSameFile(VrmlJavaValidator validator) {
		if (file == null) {
			return false;
		}
		return validator.equals(file);
	}
	
	public void addField(String name, FieldType fieldType, FType sType) {
		fieldList.put(name, new FieldDef(sType, fieldType, name));
	}
	
	public String getName() {
		return name;
	}
	
	public FType getFieldType(String field) {
		if (fieldList.containsKey(field)) {
			return fieldList.get(field).getsType();
		} else {
			return null;
		}
	}
	
	public boolean isEventIn(String field) {
		FieldDef f = fieldList.get(field);
		if (f != null) {
			// Un exposedField peut à la fois être un eventIn et un eventOut (il envoie et reçoit les modifications)
			return f.getFieldType().equals(FieldType.EVENT_IN) || f.getFieldType().equals(FieldType.EXPOSED_FIELD);
		}
		return false;
	}
	
	public boolean isEventOut(String field) {
		FieldDef f = fieldList.get(field);
		if (f != null) {
			// Un exposedField peut à la fois être un eventIn et un eventOut (il envoie et reçoit les modifications)
			return f.getFieldType().equals(FieldType.EVENT_OUT) || f.getFieldType().equals(FieldType.EXPOSED_FIELD);
		}
		return false;
	}
	
	public List<FieldDef> getFieldsName() {
		List<FieldDef> list = new LinkedList<FieldDef>();
		for (FieldDef f : fieldList.values()) {
			list.add(f);
		}
		return list;
	}
	
	public String toString() {
		String fieldString = "";
		for (FieldDef f : fieldList.values()) {
			fieldString += f.getName() + " -> " + f.getFieldType() + ", " + f.getsType() + "\n";
		}
		return name + "[" + fieldString + "]";
	}
}
