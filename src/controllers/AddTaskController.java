package controllers;

import model.DateValues;
import model.Task;
import views.AddTaskView;

public class AddTaskController {
	
	AddTaskView screen;

	public AddTaskController(AddTaskView screen) {
		this.screen = screen;
	}

	public void handleAddTask() {
		if (!validateValues())
			return;

		String title = screen.getTitle();
		String description = screen.getDescription();
		DateValues date = screen.getDateValue();

		Task task = screen.taskManager.addTask(title, description, date.origin);
		// save to file
		screen.taskDAO.add(task);

		screen.resetValues();
	}
	
	public void handleEditTask(int taskID) {
		if (!validateValues())
			return;

		String title = screen.getTitle();
		String description = screen.getDescription();
		DateValues date = screen.getDateValue();

		Task task = screen.taskManager.createTask(title, description, date.origin, taskID);
		screen.taskManager.updateTask(taskID, task);
		screen.taskDAO.update(taskID, task);
		screen.resetValues();
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
