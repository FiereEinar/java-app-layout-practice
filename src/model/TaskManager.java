package model;

import java.util.ArrayList;

public class TaskManager {
	
	public ArrayList<Task> tasks = new ArrayList<>();

	public TaskManager() {
	}
	
	public void addTask() {
		tasks.add(new Task(null, null, null, null));
	}

}
