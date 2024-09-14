package controllers;

import database.TaskDAO;
import model.TaskManager;
import views.AllTasksView;

public class AllTasksController {
  
  public TaskManager taskManager;
	public AllTasksView screen;
  public TaskDAO taskDAO;

  public AllTasksController(TaskManager tm, AllTasksView screen, TaskDAO taskDAO) {
    this.taskManager = tm;
    this.screen = screen;
    this.taskDAO = taskDAO;
  }

  // TODO: actually implement this
  public void handleUpdateTask(int taskID) {
    
  }
}
