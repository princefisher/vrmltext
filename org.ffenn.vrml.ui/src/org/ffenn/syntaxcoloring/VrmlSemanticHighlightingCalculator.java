package org.ffenn.syntaxcoloring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.impl.RuleCallImpl;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class VrmlSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}

		Iterable<AbstractNode> allNodes = NodeUtil.getAllContents(resource.getParseResult().getRootNode());
		for (AbstractNode abstractNode : allNodes) {
			if (abstractNode.getGrammarElement() instanceof RuleCallImpl) {
				RuleCallImpl node = (RuleCallImpl) abstractNode.getGrammarElement();
				if (node.getRule().getName().equals("RouteStatement")) {
					for (EObject o : abstractNode.eContents()) {
						LeafNode n = (LeafNode) o;
						if (n.getFeature() != null) {
							if (n.getFeature().equals("nodeNameID")) {
								acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
							} else if (n.getFeature().equals("eventIn")) {
								acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
							} else if (n.getFeature().equals("eventOutName")) {
								acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.PINK);
							}
						}
					}
				} else if (node.getRule().getName().equals("NodeStatement")) {
					for (EObject o : abstractNode.eContents()) {
						if (o instanceof LeafNode) {
							LeafNode n = (LeafNode) o;
							if (n.getFeature() != null) {
								if (n.getFeature().equals("nodeNameDEF")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
								} else if (n.getFeature().equals("nodeNameID")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
								}
							}
						}
					}
				} else if (node.getRule().getName().equals("Node")) {
					for (EObject o : abstractNode.eContents()) {
						if (o instanceof LeafNode) {
							LeafNode n = (LeafNode) o;
							if (n.getFeature() != null) {
								if (n.getFeature().equals("name")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
								}
							}
						}
					}
				} else if (node.getRule().getName().equals("NodeBodyElement")) {
					for (EObject o : abstractNode.eContents()) {
						if (o instanceof LeafNode) {
							LeafNode n = (LeafNode) o;
							if (n.getFeature() != null) {
								if (n.getFeature().equals("fieldName")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
								} else if (n.getFeature().equals("fieldId")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
								} else if (n.getFeature().equals("field")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.YELLOW);
								} else if (n.getFeature().equals("eventInId")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
								} else if (n.getFeature().equals("eventInName")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
								} else if (n.getFeature().equals("eventOutId")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.PINK);
								} else if (n.getFeature().equals("eventOutName")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.PINK);
								}
							}
						}
					}
				}
			}
		}
	}

}
