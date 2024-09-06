package ui;

import main.CustomColor;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InputField extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Input title;
	public NormalMutedText label;
	
	public InputField(String labelText) {	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.label = new NormalMutedText(labelText);
		this.label.setAlignmentX(Container.LEFT_ALIGNMENT);
		this.title = new Input();
		
		this.setBackground(CustomColor.dark_200);
		
		this.add(this.label);
		this.add(this.title);
	}

}
