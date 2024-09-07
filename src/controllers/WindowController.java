package controllers;

import main.Window;
import model.TaskManager;
import views.AddTaskView;
import views.AllTasksView;
import views.FinishedTasksView;
import views.UpcomingTasksVIew;

public class WindowController {
	
	Window window;
	TaskManager taskManager = new TaskManager();
	
	// views
	AllTasksView allTasksView;
	AddTaskView addTaskView;
	UpcomingTasksVIew upcomingTasksVIew;
	FinishedTasksView finishedTasksView;

	public WindowController(Window window) {
		this.window = window;
		
		// initialize views
		allTasksView = new AllTasksView(this.taskManager);
		addTaskView = new AddTaskView(this.taskManager);
		upcomingTasksVIew = new UpcomingTasksVIew(this.taskManager);
		finishedTasksView = new FinishedTasksView(this.taskManager);
	}
	
	public void handleAllTasks() {
		window.mainContent.removeAll();
		window.title.setText("All Tasks");
		
		allTasksView.render();
		window.mainContent.add(allTasksView);
	}
	
	public void handleAddTask() {
		window.mainContent.removeAll();
		window.title.setText("Add Task");
		
		addTaskView.render();
		window.mainContent.add(addTaskView);
	}
	
	public void handleUpcomingTasks() {
		window.mainContent.removeAll();
		window.title.setText("Upcoming Task");

		upcomingTasksVIew.render();
		window.mainContent.add(upcomingTasksVIew);
	}
	
	public void handleFinishedTask() {
		window.mainContent.removeAll();
		window.title.setText("Finished Task");

		finishedTasksView.render();
		window.mainContent.add(finishedTasksView);
	}

}
