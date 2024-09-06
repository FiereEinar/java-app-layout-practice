package ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;

public class NormalMutedText extends JLabel {

	private static final long serialVersionUID = 1L;

	public NormalMutedText(String text) {
		super(text);
		this.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
		this.setForeground(CustomColor.dark_500);
		this.setAlignmentX(Container.RIGHT_ALIGNMENT);
	}

}
