package views;

import java.awt.Font;

import javax.swing.JLabel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;

public class AllTasksView extends MainLayout {

	private static final long serialVersionUID = 1L;
	
	public AllTasksView(TaskManager tm) {
		super(tm);
	}

	public void render() {
		if (taskManager.tasks.size() == 0) {
			JLabel label = new JLabel("No tasks yet");
			label.setFont(new Font(Window.font, Font.ITALIC, CustomFontSize.small));
			label.setForeground(CustomColor.dark_500);
			
			this.add(label);
		} else {
			// render tasks
		}
	}

}
