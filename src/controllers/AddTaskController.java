package controllers;

import database.TaskDAO;
import model.Task;
import model.TaskManager;
import views.AddTaskView;

public class AddTaskController {
	
	TaskManager taskManager;
	AddTaskView screen;
	TaskDAO taskDAO;

	public AddTaskController(AddTaskView screen, TaskManager tm) {
		this.taskManager = tm;
		this.screen = screen;
		this.taskDAO = new TaskDAO(taskManager);
	}

	public void handleAddTask() {
		if (!validateValues()) return;
		
		String title = screen.getTitle();
		String description = screen.getDescription();
		
		int year = screen.getYear();
		int month = screen.getMonth();
		int day = screen.getDayOfMonth();
		
		int hour = screen.getHour();
		int minutes = screen.getMinutes();
		
		Task task = taskManager.addTask(title, description, year, month, day, hour, minutes);
		// save to file
		taskDAO.saveTask(task);
	}
	
	private Boolean validateValues() {
		if (screen.getTitle().length() == 0) return false;
		if (screen.getDescription().length() == 0) return false;
		
		if (screen.getYear() > 9999) return false;
		if (screen.getMonth() > 12) return false;
		if (screen.getDayOfMonth() > 31) return false;
		
		if (screen.getHour() > 24) return false;
		if (screen.getMinutes() > 59) return false;
		
		return true;
	}

}
