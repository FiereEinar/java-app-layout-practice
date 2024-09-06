package views;

import java.awt.Font;

import javax.swing.JLabel;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;

public class AddTaskView extends MainLayout {

	private static final long serialVersionUID = 1L;
	
	public AddTaskView(TaskManager tm) {
		super(tm);
	}
	
	public void render() {
//		JPanel formContainer = new JPanel();
//		formContainer.setLayout(new GridLayout(2, 2));

		JLabel label = new JLabel("Add task form goes here");
		label.setFont(new Font(Window.font, Font.ITALIC, CustomFontSize.small));
		label.setForeground(CustomColor.dark_500);
		
		this.add(label);
	}

}
