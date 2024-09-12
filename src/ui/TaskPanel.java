package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import main.CustomColor;

public class TaskPanel extends RoundedButton {
	
	private static final long serialVersionUID = 1L;
	private final int labelWidth = 250;
	private final int panelHeight = 40;
	
	JCheckBox checkbox;
	NormalMutedText title;
	NormalMutedText description;
	NormalMutedText deadline;
	RoundedButton deleteButton;
	
	public TaskPanel(Boolean isDone, String title, String description, Date deadline) {
		super("");
		
		int componentAmount = 4;
		this.checkbox = new JCheckBox();
		this.checkbox.setBackground(CustomColor.dark_200);
		this.checkbox.setSelected(isDone);

		this.title = new NormalMutedText(title);
		this.title.setPreferredSize(new Dimension(labelWidth, this.title.getFont().getSize()));
		this.title.setHorizontalAlignment(SwingConstants.LEFT);

		this.description = new NormalMutedText(description);
		this.description.setPreferredSize(new Dimension(labelWidth, this.title.getFont().getSize()));
		this.description.setHorizontalAlignment(SwingConstants.LEFT);

		this.deadline = new NormalMutedText(deadline.toString());
		this.deadline.setPreferredSize(new Dimension(labelWidth, this.title.getFont().getSize()));
		this.deadline.setHorizontalAlignment(SwingConstants.LEFT);

		this.deleteButton = new RoundedButton("Delete");
		this.deleteButton.setOriginalBackgroundColor(CustomColor.danger);
		this.deleteButton.setHoverBackgroundColor(CustomColor.danger);
		this.deleteButton.setForegroundHover(CustomColor.white);
		this.deleteButton.setForegroundDefault(CustomColor.white);

		this.setBackground(CustomColor.dark_200);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOriginalBackgroundColor(CustomColor.dark_200);
		this.setHoverBackgroundColor(CustomColor.dark_400);
		this.setAlignmentX(Container.RIGHT_ALIGNMENT);
		this.setPreferredSize(new Dimension(labelWidth * componentAmount, panelHeight));
		this.setVerticalAlignment(SwingConstants.TOP);
		
		this.add(this.checkbox);
		this.add(this.title);
		this.add(this.description);
		this.add(this.deadline);
		this.add(this.deleteButton);
	}

}
