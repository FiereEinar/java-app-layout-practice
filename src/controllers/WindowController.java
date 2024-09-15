package controllers;

import database.TaskDAO;
import main.Window;
import model.TaskManager;
import views.AddTaskView;
import views.AllTasksView;
import views.FinishedTasksView;
import views.UpcomingTasksVIew;

public class WindowController {
	
	public Window window;
	TaskManager taskManager = new TaskManager();
	TaskDAO taskDAO = new TaskDAO(taskManager);
	
	// views
	public AllTasksView allTasksView;
	public AddTaskView addTaskView;
	public UpcomingTasksVIew upcomingTasksVIew;
	public FinishedTasksView finishedTasksView;

	public WindowController(Window window) {
		this.window = window;
		
		// initialize views
		allTasksView = new AllTasksView(window, this.taskManager, taskDAO);
		addTaskView = new AddTaskView(window, this.taskManager, taskDAO);
		upcomingTasksVIew = new UpcomingTasksVIew(window, this.taskManager, taskDAO);
		finishedTasksView = new FinishedTasksView(window, this.taskManager, taskDAO);
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
