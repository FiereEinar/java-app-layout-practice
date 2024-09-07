package model;

import java.util.Calendar;

public class Task {
	
	public String title;
	public String description;
	public Boolean finished;
	public Calendar deadline;
	
	public Task(String title, String description, Boolean finished, Calendar deadline) {
		this.title = title;
		this.description = description;
		this.finished = finished;
		this.deadline = deadline;
	}

}
