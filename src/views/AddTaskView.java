package views;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;
import ui.InputField;

public class AddTaskView extends MainLayout {

	private static final long serialVersionUID = 1L;
	
	InputField titleField;
	InputField descriptionField;
	
	public AddTaskView(TaskManager tm) {
		super(tm);

	}
	
	public void render() {
		JPanel formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
		formContainer.setBackground(CustomColor.dark_200);
//		JLabel label = new JLabel("Add task form goes here");
//		label.setFont(new Font(Window.font, Font.ITALIC, CustomFontSize.small));
//		label.setForeground(CustomColor.dark_500);
//		label.setAlignmentX(Container.RIGHT_ALIGNMENT);
		
		titleField = new InputField("Title: ");
		descriptionField = new InputField("Description: ");

		formContainer.add(titleField);
		formContainer.add(descriptionField);
		
		JPanel titleFieldContainer = new JPanel();
		titleFieldContainer.setBackground(CustomColor.dark_200);
//		titleFieldContainer.setLayout(new BoxLayout(formContainer, BoxLayout.X_AXIS));
		titleFieldContainer.setAlignmentX(Container.RIGHT_ALIGNMENT);

		JTextField title = new JTextField();
		title.setPreferredSize(new Dimension(200, 20));
		
		JLabel titleLabel = new JLabel("Title: ");
		
		titleFieldContainer.add(titleLabel);
		titleFieldContainer.add(title);
		
//		formContainer.add(titleFieldContainer);
		
//		this.add(label);
		this.add(formContainer);
	}

}
