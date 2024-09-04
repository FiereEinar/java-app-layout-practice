package controllers;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;

public class WindowController {
	
	Window window;
	TaskManager taskManager = new TaskManager();
	private JLabel messageLabel = new JLabel();
	private JPanel content = new JPanel();

	public WindowController(Window window) {
		this.window = window;
		
		content.add(messageLabel);
	}
	
	public void handleAllTasks() {
		System.out.println("All Tasks");
		window.title.setText("All Tasks");
		
		JPanel tasksContainer = new JPanel();
		tasksContainer.setBackground(CustomColor.dark_200);
		tasksContainer.setLayout(new FlowLayout(FlowLayout.LEFT));

		if (taskManager.tasks.size() == 0) {
			JLabel label = new JLabel("No tasks yet");
			label.setFont(new Font(window.font, Font.ITALIC, CustomFontSize.small));
			label.setForeground(CustomColor.dark_500);
			tasksContainer.add(label);
		} else {
			// render tasks
		}
		
		window.mainContent.add(tasksContainer);
	}
	
	public void handleAddTask() {
		System.out.println("Add Task");
		window.title.setText("Add Task");
	}
	
	public void handleUpcomingTasks() {
		System.out.println("Upcoming Tasks");
		window.title.setText("Upcoming Tasks");
	}
	
	public void handleFinishedTask() {
		System.out.println("Finished Tasks");
		window.title.setText("Finished Tasks");
	}

}
