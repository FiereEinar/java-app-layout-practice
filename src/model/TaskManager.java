package model;

import java.util.ArrayList;
import java.util.Calendar;

import main.Utils;

public class TaskManager {
	
	public ArrayList<Task> tasks = new ArrayList<>();

	public TaskManager() {
	}
	
	public Task addTask(String title, String description, int year, int month, int day, int hour, int minutes) {
		Calendar deadline = Calendar.getInstance();
		deadline.set(Calendar.YEAR, year);
		deadline.set(Calendar.MONTH, month);
		deadline.set(Calendar.DAY_OF_MONTH, day);
		deadline.set(Calendar.HOUR, hour);
		deadline.set(Calendar.MINUTE, minutes);

		Task task = new Task(title, description, false, deadline, Utils.generateID());

		tasks.add(task);

		return task;
	}

	public void deleteTask(int id) {
		tasks.removeIf(t -> (t.id == id));
	}

}
