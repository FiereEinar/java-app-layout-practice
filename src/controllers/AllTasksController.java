package controllers;

import model.Task;
import views.AllTasksView;

public class AllTasksController {
  
	public AllTasksView screen;

  public AllTasksController(AllTasksView screen) {
    this.screen = screen;
  }

  public void handleDeleteTask(int taskID) {
    screen.taskDAO.deleteTask(taskID);
    screen.taskManager.deleteTask(taskID);
  }

  // TODO: actually implement this
  public void handleCheckboxUpdate(int taskID, Boolean checked) {
    // update in memory
    for (Task t : screen.taskManager.tasks) {
      if (t.id == taskID) {
        t.finished = checked;
        break;
      }
    }
    
    // update from storage
    screen.taskDAO.updateTaskFinishedStatus(taskID, checked);
  }
}
