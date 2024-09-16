package views;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import database.TaskDAO;
import main.CustomColor;
import main.Window;
import model.TaskManager;

interface MainLayoutInterface {
	void render();
}

public class MainLayout extends JPanel implements MainLayoutInterface {

	private static final long serialVersionUID = 1L;
	public TaskManager taskManager;
	public TaskDAO taskDAO;
	public Window window;

	public MainLayout(Window window, TaskManager taskManager, TaskDAO taskDAO) {
		this.taskManager = taskManager;
		this.taskDAO = taskDAO;
		this.window = window;

		this.setBackground(CustomColor.dark_200);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// render();
	}

	@Override
	public void render() {
	}

}
