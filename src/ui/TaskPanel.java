package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
	RoundedButton deleteButton;
	
	public TaskPanel(Boolean isDone, String title, String description, Date deadline) {
		this.checkbox = new JCheckBox();
		this.checkbox.setBackground(CustomColor.dark_200);
		this.checkbox.setSelected(isDone);
		
		this.title = new NormalMutedText(title);
		this.title.setPreferredSize(new Dimension(200, this.title.getHeight()));
		this.title.setAlignmentX(BOTTOM_ALIGNMENT);

		this.description = new NormalMutedText(description);

		this.deadline = new NormalMutedText(deadline.toString());

		this.deleteButton = new RoundedButton("Delete");
		this.deleteButton.setOriginalBackgroundColor(CustomColor.danger);
		this.deleteButton.setHoverBackgroundColor(CustomColor.danger);
		this.deleteButton.setForegroundHover(CustomColor.white);
		this.deleteButton.setForegroundDefault(CustomColor.white);

		this.setBackground(CustomColor.dark_200);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		// this.setLayout(new GridLayout(1, 5, 0, 0));
		
		this.add(this.checkbox);
		this.add(this.title);
		this.add(this.description);
		this.add(this.deadline);
		this.add(this.deleteButton);
	}

}
