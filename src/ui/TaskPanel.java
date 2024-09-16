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
import model.Task;

public class TaskPanel extends RoundedButton {
	
	private static final long serialVersionUID = 1L;
	private final int labelWidth = 250;
	private final int panelHeight = 40;
	
	JCheckBox checkbox;
	NormalMutedText title;
	NormalMutedText description;
	NormalMutedText deadline;
	RoundedButton deleteButton;
	AllTasksController controller;
	int id;
	
	public TaskPanel(AllTasksController controller, Boolean isDone, String title, String description, Date deadline,
			int id) {
		super("");
		this.controller = controller;
		this.id = id;
		int componentAmount = 4;

		// TaskPanel styling / configurations
		this.setBackground(CustomColor.dark_200);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOriginalBackgroundColor(CustomColor.dark_200);
		this.setHoverBackgroundColor(CustomColor.dark_400);
		this.setAlignmentX(Container.RIGHT_ALIGNMENT);
		this.setPreferredSize(new Dimension(labelWidth * componentAmount, panelHeight));
		this.setVerticalAlignment(SwingConstants.TOP);

		// on click listener
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Task thisTask = controller.screen.taskManager.find(id);

				// render the add task form
				controller.screen.window.controller.handleAddTask();
				// set values for the form
				controller.screen.window.controller.addTaskView.setValues(thisTask);
				// set form title
				controller.screen.window.title.setText("Edit Task");	
			}
		});

		// setup components inside this task panel
		setupCheckbox(isDone);
		setupTitle(title);
		setupDescription(description);
		setupDeadline(deadline);
		setupDeleteButton();

		// add the components to this panel
		this.add(this.checkbox);
		this.add(this.title);
		this.add(this.description);
		this.add(this.deadline);
		this.add(this.deleteButton);
	}

	/**
	 * Removes itself from the parent, used when this component is deleted
	 */
	private void removeSelf() {
		// get the components (TaskPanels) inside the screen container
		Component[] componentList = controller.screen.getComponents();

		// find this exact component and remove it from the parent
		for (Component c : componentList) {
			if (c == this) {
				controller.screen.remove(c);
			}
		}

		controller.screen.revalidate();
		controller.screen.repaint();
	}

	private void setupCheckbox(Boolean isDone) {
		checkbox = new JCheckBox();
		checkbox.setBackground(CustomColor.dark_200);
		checkbox.setSelected(isDone);
		checkbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleCheckboxUpdate(id, checkbox.isSelected());
			}
		});
	}

	private void setupTitle(String text) {
		title = new NormalMutedText(text);
		title.setPreferredSize(new Dimension(labelWidth, title.getFont().getSize()));
		title.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void setupDescription(String text) {
		description = new NormalMutedText(text);
		description.setPreferredSize(new Dimension(labelWidth, title.getFont().getSize()));
		description.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void setupDeadline(Date date) {
		deadline = new NormalMutedText(date.toString());
		deadline.setPreferredSize(new Dimension(labelWidth, title.getFont().getSize()));
		deadline.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void setupDeleteButton() {
			deleteButton = new RoundedButton("Delete");
			deleteButton.setOriginalBackgroundColor(CustomColor.danger);
			deleteButton.setHoverBackgroundColor(CustomColor.danger);
			deleteButton.setForegroundHover(CustomColor.white);
			deleteButton.setForegroundDefault(CustomColor.white);
			deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleDeleteTask(id);
				removeSelf();
			}
		});
	}

}
