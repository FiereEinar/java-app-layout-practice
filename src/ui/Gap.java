package ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;

import main.CustomColor;

public class Gap extends JPanel {

	public Gap(int w, int h) {
		this.add(Box.createRigidArea(new Dimension(w, h)));
		this.setBackground(CustomColor.dark_200);
	}

}
