package ui;

import javax.swing.border.EmptyBorder;

import main.CustomColor;

public class SidebarButton extends RoundedButton {

	private static final long serialVersionUID = 1L;

	public SidebarButton(String label) {
		super(label);
		this.setOriginalBackgroundColor(CustomColor.dark_300);
		this.setHoverBackgroundColor(CustomColor.dark_400);
		this.setForeground(CustomColor.dark_500);
		this.setBorder(new EmptyBorder(10, 25, 10, 25));
	}

}
