package views;

import java.awt.Font;

import javax.swing.JLabel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;

public class FinishedTasksView extends MainLayout {

	private static final long serialVersionUID = 1L;

	TaskManager taskManager;
	
	public FinishedTasksView(TaskManager tm) {
		super(tm);
	}
	
	public void render() {
		JLabel label = new JLabel("Upcoming tasks goes here");
		label.setFont(new Font(Window.font, Font.ITALIC, CustomFontSize.small));
		label.setForeground(CustomColor.dark_500);
		
		this.add(label);
	}

}
