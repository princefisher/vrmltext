/*
* generated by Xtext
*/
package org.ffenn.labeling;

import org.eclipse.xtext.ui.core.DefaultLabelProvider;
import org.ffenn.vrml.DefStatement;
import org.ffenn.vrml.Node;
import org.ffenn.vrml.Proto;
import org.ffenn.vrml.Script;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 * Class that provides name associated with grammar rules in the outline
 * 
 * Best example is with Proto Rule that will display "PROTO" in the outline (first keyword of Proto Rule)
 * There, it will add the name of this proto
 */
public class VrmlLabelProvider extends DefaultLabelProvider {
	
	/*
	 * Rule for PROTO : PROTO protoname
	 */
	String text(Proto el) {
		return "PROTO " + el.getName();
	}

	/*
	 * Rule for Node : nodename
	 */
	String text(Node el) {
		return el.getName();
	}
	
	/*
	 * Rule for DefStatement : DEF nodename [nodetype]
	 */
	String text(DefStatement el) {
		String text = "DEF " + el.getName();
		if (el.getNode() instanceof Script) {
			text += " [Script]";
		} else if (el.getNode() instanceof Node) {
			text += " [" + ((Node)el.getNode()).getName() + "]";
		}
		return text;
	}
}
