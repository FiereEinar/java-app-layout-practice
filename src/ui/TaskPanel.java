package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import controllers.AllTasksController;
import main.CustomColor;

public class TaskPanel extends RoundedButton {
	
	private static final long serialVersionUID = 1L;
	private final int labelWidth = 230;
	private final int panelHeight = 40;
	
	JCheckBox checkbox;
	NormalMutedText title;
	NormalMutedText description;
	NormalMutedText deadline;
	RoundedButton deleteButton;
	AllTasksController controller;
	int id;
	
	public TaskPanel(AllTasksController controller, Boolean isDone, String title, String description, Date deadline, int id) {
		super("");
		this.controller = controller;
		this.id = id;
		int componentAmount = 4;

		// TaskPanel styling
		this.setBackground(CustomColor.dark_200);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOriginalBackgroundColor(CustomColor.dark_200);
		this.setHoverBackgroundColor(CustomColor.dark_400);
		this.setAlignmentX(Container.RIGHT_ALIGNMENT);
		this.setPreferredSize(new Dimension(labelWidth * componentAmount, panelHeight));
		this.setVerticalAlignment(SwingConstants.TOP);

		this.checkbox = new JCheckBox();
		this.checkbox.setBackground(CustomColor.dark_200);
		this.checkbox.setSelected(isDone);
		this.checkbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.taskManager.tasks.forEach(t -> {
					if (id == t.id) {
						t.finished = checkbox.isSelected();
						// update the storage
						controller.handleUpdateTask(id);
					}
				});
			}
		});

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
		this.deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.taskDAO.deleteTask(id);
				controller.taskManager.deleteTask(id);
				removeSelf();
			}
		});

		this.add(this.checkbox);
		this.add(this.title);
		this.add(this.description);
		this.add(this.deadline);
		this.add(this.deleteButton);
	}

	private void removeSelf() {
		Component[] componentList = controller.screen.getComponents();

		for (Component c : componentList) {
			if (c == this) {
				controller.screen.remove(c);
			}
		}

		controller.screen.revalidate();
		controller.screen.repaint();
	}

}
