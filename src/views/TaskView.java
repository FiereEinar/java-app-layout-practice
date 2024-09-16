package views;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.TaskDAO;
import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.Task;
import model.TaskManager;
import ui.Gap;
import ui.RoundedButton;

public class TaskView extends MainLayout {

  Task task;

  public TaskView(Window window, TaskManager taskManager, TaskDAO taskDAO) {
    super(window, taskManager, taskDAO);
  }

  public void render() {
    this.removeAll();

    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST; // Align components to the left
    gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

    // task description
    JLabel description = new JLabel(task.description);
    description.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.medium));
    description.setForeground(CustomColor.dark_500);
    description.setAlignmentX(Container.RIGHT_ALIGNMENT);

    // deadline label
    JLabel deadlineLabel = new JLabel("Deadline:");
    deadlineLabel.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
    deadlineLabel.setForeground(CustomColor.dark_500);
    deadlineLabel.setAlignmentX(Container.RIGHT_ALIGNMENT);

    // deadline
    JLabel deadline = new JLabel(task.deadline.getTime().toString());
    deadline.setFont(new Font(Window.font, Font.PLAIN, CustomFontSize.small));
    deadline.setForeground(CustomColor.dark_500);
    deadline.setAlignmentX(Container.RIGHT_ALIGNMENT);

    JPanel actionsContainer = new JPanel();
    actionsContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    actionsContainer.setBackground(CustomColor.dark_200);

    // delete button
    RoundedButton deleteButton = new RoundedButton("Delete");
    deleteButton.setOriginalBackgroundColor(CustomColor.danger);
    deleteButton.setHoverBackgroundColor(CustomColor.danger);
    deleteButton.setForegroundHover(CustomColor.white);
    deleteButton.setForegroundDefault(CustomColor.white);
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        taskManager.deleteTask(task.id);
        window.controller.handleAllTasks();
      }
    });

    // delete button
    RoundedButton updateButton = new RoundedButton("Update");
    updateButton.setOriginalBackgroundColor(CustomColor.ocean);
    updateButton.setHoverBackgroundColor(CustomColor.ocean);
    updateButton.setForegroundHover(CustomColor.white);
    updateButton.setForegroundDefault(CustomColor.white);
    updateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // render the add task form
				window.controller.handleAddTask();
				// set values for the form
				window.controller.addTaskView.setValues(task);
				// set form title
				window.title.setText("Edit Task");	
      }
    });

    actionsContainer.add(deleteButton);
    actionsContainer.add(new Gap(5, 0));
    actionsContainer.add(updateButton);

    // Description
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    this.add(description, gbc);

    // Deadline label
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    this.add(deadlineLabel, gbc);

    // Deadline value
    gbc.gridx = 1;
    gbc.gridy = 1;
    this.add(deadline, gbc);

    // Actions container
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    this.add(actionsContainer, gbc);
  }
  
  public void setValue(Task task) {
    this.task = task;
  }
  
}
