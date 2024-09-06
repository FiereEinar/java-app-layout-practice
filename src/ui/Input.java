package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;

public class Input extends JTextField {

	private static final long serialVersionUID = 1L;

	public Input(String text) {
		super(text);
		setStyles();
	}
	
	public Input() {
		setStyles();
	}
	
	private void setStyles() {
		this.setPreferredSize(new Dimension(200, 30));
		this.setBackground(CustomColor.dark_200);
		this.setForeground(CustomColor.dark_500);
		this.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
		this.setCaretColor(CustomColor.dark_500);
	}

}
