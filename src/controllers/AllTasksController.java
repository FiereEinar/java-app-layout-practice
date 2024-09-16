package controllers;

import model.Task;
import views.AllTasksView;

public class AllTasksController {
  
	public AllTasksView screen;

    public AllTasksController(AllTasksView screen) {
      this.screen = screen;
    }

  /**
   * Handles the deletion of task in both memory and storage
   * @param taskID
   */
  public void handleDeleteTask(int taskID) {
    screen.taskDAO.remove(taskID);
    screen.taskManager.deleteTask(taskID);
  }

  /**
   * Keeps checked status in memory and storage synced
   * @param taskID
   * @param checked
   */
  public void handleCheckboxUpdate(int taskID, Boolean checked) {
    Task task = null;

    // update in memory
    for (Task t : screen.taskManager.tasks) {
      if (t.id == taskID) {
        t.finished = checked;
        task = t;
        break;
      }
    }
    
    // update from storage
    screen.taskDAO.update(taskID, task);
  }
}
