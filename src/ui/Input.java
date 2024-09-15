package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;

public class Input extends JTextField {

	private static final long serialVersionUID = 1L;
	public static final int width = 250;
	public static final int height = 30;

	public Input(String text) {
		super(text);
		setStyles();
	}
	
	public Input() {
		setStyles();
	}
	
	private void setStyles() {
		this.setPreferredSize(new Dimension(width, Input.height));
		this.setBackground(CustomColor.dark_200);
		this.setForeground(CustomColor.dark_500);
		this.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
		this.setCaretColor(CustomColor.dark_500);
		this.setBorder(new LineBorder(CustomColor.dark_400, 1));
		this.setFocusable(true);
	}

}
