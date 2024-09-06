package views;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import main.CustomColor;
import model.TaskManager;

interface MainLayoutInterface {
	void render();
}

public class MainLayout extends JPanel implements MainLayoutInterface {

	private static final long serialVersionUID = 1L;
	TaskManager taskManager;

	public MainLayout(TaskManager taskManager) {
		this.taskManager  = taskManager;
		this.setBackground(CustomColor.dark_200);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		render();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
