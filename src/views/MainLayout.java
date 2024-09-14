package views;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import database.TaskDAO;
import main.CustomColor;
import model.TaskManager;

interface MainLayoutInterface {
	void render();
}

public class MainLayout extends JPanel implements MainLayoutInterface {

	private static final long serialVersionUID = 1L;
	TaskManager taskManager;
	TaskDAO taskDAO;

	public MainLayout(TaskManager taskManager, TaskDAO taskDAO) {
		this.taskManager = taskManager;
		this.taskDAO = taskDAO;
		
		this.setBackground(CustomColor.dark_200);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		render();
	}

	@Override
	public void render() {
	}

}
