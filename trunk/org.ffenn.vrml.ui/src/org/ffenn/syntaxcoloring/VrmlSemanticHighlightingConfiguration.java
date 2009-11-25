package org.ffenn.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

public class VrmlSemanticHighlightingConfiguration implements ISemanticHighlightingConfiguration {

	public static final String TERMINAL_STRING = "chaine";
	public static final String DARKRED = "rouge sombre";
	public static final String RED = "rouge";
	public static final String BLUE = "bleu";
	public static final String GREEN = "vert";
	public static final String PINK = "rose";
	public static final String YELLOW = "jaune";
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(TERMINAL_STRING, "String", chaine());
		acceptor.acceptDefaultHighlighting(DARKRED, "Texte rouge sombre", rougeSombre());
		acceptor.acceptDefaultHighlighting(RED, "Texte rouge", rouge());
		acceptor.acceptDefaultHighlighting(BLUE, "Texte bleu", bleu());
		acceptor.acceptDefaultHighlighting(GREEN, "Texte vert", vert());
		acceptor.acceptDefaultHighlighting(PINK, "Texte rose", rose());
		acceptor.acceptDefaultHighlighting(YELLOW, "Texte jaune", jaune());
	}

	public TextStyle chaine() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(35, 33, 118));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
	
	public TextStyle rouge() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(255, 21, 21));
		return textStyle;
	}
	
	public TextStyle rougeSombre() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(147, 31, 31));
		return textStyle;
	}
	
	public TextStyle rose() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(255, 15, 255));
		return textStyle;
	}
	
	public TextStyle bleu() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 181));
		return textStyle;
	}
	
	public TextStyle vert() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 132, 0));
		return textStyle;
	}
	
	public TextStyle jaune() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(132, 130, 4));
		return textStyle;
	}
	
}
