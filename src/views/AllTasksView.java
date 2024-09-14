package views;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;

import controllers.AllTasksController;
import database.TaskDAO;
import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.Task;
import model.TaskManager;
import ui.TaskPanel;

public class AllTasksView extends MainLayout {

	private static final long serialVersionUID = 1L;

	AllTasksController controller; 
	
	public AllTasksView(Window window, TaskManager tm, TaskDAO taskDAO) {
		super(window, tm, taskDAO);
		this.controller = new AllTasksController(tm, this, taskDAO);
	}

	public void render() {
		this.removeAll();
		
		if (taskManager.tasks.size() == 0) {
			JLabel label = new JLabel("No tasks yet");
			label.setFont(new Font(Window.font, Font.ITALIC, CustomFontSize.small));
			label.setForeground(CustomColor.dark_500);
			label.setAlignmentX(JLabel.LEFT);
			
			this.add(label);
		} else {
			// render tasks
			for (Task task : taskManager.tasks) {
				this.add(new TaskPanel(controller, task.finished, task.title, task.description, task.deadline.getTime(), task.id));
				this.add(Box.createRigidArea(new Dimension(0, 10)));
			}
		}
	}

}
