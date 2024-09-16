package model;

import java.util.ArrayList;
import java.util.Calendar;

import main.Utils;

public class TaskManager {
	
	public ArrayList<Task> tasks = new ArrayList<>();

	public TaskManager() {
	}
	
	// TODO: refactor date info to use DateValues
	public Task addTask(String title, String description, Calendar deadline) {
		Task task = createTask(title, description, deadline, Utils.generateID());
		tasks.add(task);
		return task;
	}

	public void updateTask(int taskID, Task updatedTask) {
		for (Task task : tasks) {
			if (task.id == taskID) {
				task.title = updatedTask.title;
				task.description = updatedTask.description;
				task.description = updatedTask.description;
				task.deadline = updatedTask.deadline;
				return;
			}
		}
	}

	public Task find(int id) {
		for (Task t : tasks) {
			if (t.id == id)
				return t;
		}

		return null;
	}

	// TODO: refactor date info to use DateValues
	public Task createTask(String title, String description, Calendar deadline, int id) {
		return new Task(title, description, false, deadline, id);
	}

	public void deleteTask(int id) {
		tasks.removeIf(t -> (t.id == id));
	}

}
