package ui;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import main.CustomColor;

public class TaskPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JCheckBox checkbox;
	NormalMutedText title;
	NormalMutedText description;
	NormalMutedText deadline;
	
	public TaskPanel(Boolean isDone, String title, String description, Date deadline) {
		this.checkbox = new JCheckBox();
		this.checkbox.setBackground(CustomColor.dark_200);
		this.checkbox.setSelected(isDone);
		
		this.title = new NormalMutedText(title);
		this.description = new NormalMutedText(description);
		this.deadline = new NormalMutedText(deadline.toString());
		
		this.setBackground(CustomColor.dark_200);
		this.setLayout(new GridLayout(1, 4, 0, 0));
		
		this.add(this.checkbox);
		this.add(this.title);
		this.add(this.description);
		this.add(this.deadline);
	}

}
