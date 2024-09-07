package ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;

public class NormalText extends JLabel {

	private static final long serialVersionUID = 1L;

	public NormalText(String text) {
		super(text);
		this.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
		this.setForeground(CustomColor.white);
		this.setAlignmentX(Container.RIGHT_ALIGNMENT);
	}

}
