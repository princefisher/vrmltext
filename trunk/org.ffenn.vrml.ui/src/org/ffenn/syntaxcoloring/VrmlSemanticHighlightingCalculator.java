package org.ffenn.syntaxcoloring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.impl.RuleCallImpl;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class VrmlSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}
		
		Iterable<AbstractNode> allNodes = NodeUtil.getAllContents(resource.getParseResult().getRootNode());
		for (AbstractNode abstractNode : allNodes) {
			if (abstractNode.getGrammarElement() instanceof RuleCallImpl) {
				RuleCallImpl node = (RuleCallImpl) abstractNode.getGrammarElement();
				if (node.getRule().getName().equals("RouteStatement")) {
					colorRouteStatement(abstractNode,  acceptor);
				} else if (node.getRule().getName().equals("DefStatement")) {
					for (EObject o : abstractNode.eContents()) {
						if (o instanceof LeafNode) {
							LeafNode n = (LeafNode) o;
							if (n.getFeature() != null) {
								if (n.getFeature().equals("name")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
								} else if (n.getFeature().equals("node")) {
									acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
								}
							}
						}
					}
				} else if(node.getRule().getName().equals("FieldList")) {
					for (EObject o : abstractNode.eContents()) {
						if (o instanceof CompositeNode) {
							CompositeNode n = (CompositeNode) o;
							if(!( ((RuleCall)n.getGrammarElement()).getRule().getName().equals("SFNode") || ((RuleCall)n.getGrammarElement()).getRule().getName().equals("MFNode"))) {
								acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
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
				} else if (node.getRule().getName().equals("EventIn")) {
					colorEventIn(acceptor, abstractNode);
				} else if (node.getRule().getName().equals("EventOut")) {
					colorEventOut(acceptor, abstractNode);
				} else if (node.getRule().getName().equals("Field") || node.getRule().getName().equals("ExposedField")) {
					colorField(acceptor, abstractNode);
				} else if (node.getRule().getName().equals("NodeBodyElement")) {
					colorNodeBody(acceptor, abstractNode);
				} else {
//					System.out.println(node.getRule().getName());
				}
			}
		}
	}

	private void colorField(IHighlightedPositionAcceptor acceptor, AbstractNode abstractNode) {
		for (EObject o : abstractNode.eContents()) {
			if (o instanceof LeafNode) {
				LeafNode n = (LeafNode) o;
				if (n.getFeature() != null) {
					if (n.getFeature().equals("id")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					} else if (n.getFeature().equals("name")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					}
				}
			} else if (o instanceof CompositeNode) {
				CompositeNode n = (CompositeNode) o;
				if (((RuleCall)n.getGrammarElement()).getRule().getName().equals("FieldType")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
				}
			}
		}
	}

	private void colorEventOut(IHighlightedPositionAcceptor acceptor, AbstractNode abstractNode) {
		for (EObject o : abstractNode.eContents()) {
			if (o instanceof LeafNode) {
				LeafNode n = (LeafNode) o;
				if (n.getFeature() != null) {
					if (n.getFeature().equals("id")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					} else if (n.getFeature().equals("name")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.PINK);
					}
				}
			} else if (o instanceof CompositeNode) {
				CompositeNode n = (CompositeNode) o;
				if (((RuleCall)n.getGrammarElement()).getRule().getName().equals("FieldType")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
				}
			}
		}
	}

	private void colorEventIn(IHighlightedPositionAcceptor acceptor, AbstractNode abstractNode) {
		for (EObject o : abstractNode.eContents()) {
			if (o instanceof LeafNode) {
				LeafNode n = (LeafNode) o;
				if (n.getFeature() != null) {
					if (n.getFeature().equals("id")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					} else if (n.getFeature().equals("name")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
					}
				}
			} else if (o instanceof CompositeNode) {
				CompositeNode n = (CompositeNode) o;
				if (((RuleCall)n.getGrammarElement()).getRule().getName().equals("FieldType")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
				}
			}
		}
	}

	private void colorNodeBody(IHighlightedPositionAcceptor acceptor, AbstractNode nodeBody) {
		for (EObject o : nodeBody.eContents()) {
			if (o instanceof LeafNode) {
				LeafNode n = (LeafNode) o;
				if (n.getFeature() != null) {
					if (n.getFeature().equals("fieldName")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					} else if (n.getFeature().equals("fieldId")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
					} else if (n.getFeature().equals("field")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.YELLOW);
					} else if (n.getFeature().equals("fieldRef")) {
						acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.GREEN);
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
	
	private void colorRouteStatement(AbstractNode route,  IHighlightedPositionAcceptor acceptor) {
		for (EObject o : route.eContents()) {
			LeafNode n = (LeafNode) o;
			if (n.getFeature() != null) {
				if (n.getFeature().equals("target") || n.getFeature().equals("source")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.BLUE);
				} else if (n.getFeature().equals("eventIn")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.RED);
				} else if (n.getFeature().equals("eventOut")) {
					acceptor.addPosition(n.getOffset(), n.getLength(), VrmlSemanticHighlightingConfiguration.PINK);
				}
			}
		}
	}

}
