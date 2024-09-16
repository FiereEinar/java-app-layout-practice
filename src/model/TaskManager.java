package model;

import java.util.ArrayList;
import java.util.Calendar;

import main.Utils;

public class TaskManager {
	
	public ArrayList<Task> tasks = new ArrayList<>();

	public TaskManager() {
	}
	
	// TODO: refactor date info to use DateValues
	public Task addTask(String title, String description, int year, int month, int day, int hour, int minutes) {
		Task task = createTask(title, description, year, month, day, hour, minutes, Utils.generateID());
		tasks.add(task);
		return task;
	}

	public void updateTask(int taskID, Task updatedTask) {
		for (Task task : tasks) {
			if (task.id == taskID) {
				task.title = updatedTask.title;
				task.description = updatedTask.description;
				task.description = updatedTask.description;
				task.deadline.set(Calendar.YEAR, updatedTask.deadline.get(Calendar.YEAR));
				task.deadline.set(Calendar.MONTH, updatedTask.deadline.get(Calendar.MONTH));
				task.deadline.set(Calendar.DAY_OF_MONTH, updatedTask.deadline.get(Calendar.DAY_OF_MONTH));
				task.deadline.set(Calendar.HOUR, updatedTask.deadline.get(Calendar.HOUR));
				task.deadline.set(Calendar.MINUTE, updatedTask.deadline.get(Calendar.MINUTE));
				return;
			}
		}
	}

	// TODO: refactor date info to use DateValues
	public Task createTask(String title, String description, int year, int month, int day, int hour, int minutes, int id) {
		Calendar deadline = Calendar.getInstance();
		deadline.set(Calendar.YEAR, year);
		deadline.set(Calendar.MONTH, month);
		deadline.set(Calendar.DAY_OF_MONTH, day);
		deadline.set(Calendar.HOUR, hour);
		deadline.set(Calendar.MINUTE, minutes);

		return new Task(title, description, false, deadline, id);
	}

	public void deleteTask(int id) {
		tasks.removeIf(t -> (t.id == id));
	}

}
