package model;

import java.util.Date;

public class Task {
	
	public String title;
	public String description;
	public Boolean finished;
	public Date deadline;
	
	public Task(String title, String description, Boolean finished, Date deadline) {
		this.title = title;
		this.description = description;
		this.finished = finished;
		this.deadline = deadline;
	}

}
