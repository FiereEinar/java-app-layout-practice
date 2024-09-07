package views;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.CustomColor;
import main.CustomFontSize;
import main.Window;
import model.TaskManager;
import ui.Input;
import ui.InputField;
import ui.NormalMutedText;
import ui.RoundedButton;

public class AddTaskView extends MainLayout {

	private static final long serialVersionUID = 1L;
	private final int dateInputWidth = 150;
	
	JPanel formContainer;
	
	InputField titleField;
	InputField descriptionField;
	
	JPanel dateContainer;
	
	InputField yearField;
	InputField monthField;
	InputField dayField;
	
	JPanel timeContainer;
	
	InputField hourField;
	InputField minuteField;
	
	JPanel actionsContainer;
	
	RoundedButton submitButton;
	
	public AddTaskView(TaskManager tm) {
		super(tm);

	}
	
	public void render() {
		formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
		formContainer.setBackground(CustomColor.dark_200);
		
		// TODO: refactor this extra container
		// putting the title and description inside a container so that is has the same alignment as the rest
		JPanel c1 = new JPanel();
		c1.setBackground(CustomColor.dark_200);
		c1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel c2 = new JPanel();
		c2.setBackground(CustomColor.dark_200);
		c2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		titleField = new InputField("Title: ");
		c1.add(titleField);
		descriptionField = new InputField("Description: ");
		c2.add(descriptionField);
		
		JPanel c3 = new JPanel();
		c3.setBackground(CustomColor.dark_200);
		c3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		NormalMutedText deadlineLabel = new NormalMutedText("Deadline for this task: ");
		c3.add(deadlineLabel);
//		deadlineLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
		setupDateInputField();
		setupTimeInputField();
		setupFormActions();
		
		// add the fields to the form container
		formContainer.add(c1);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(c2);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(c3);
		formContainer.add(dateContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(timeContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(actionsContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));

		this.add(formContainer);
	}
	
	private void setupDateInputField() {
		dateContainer = new JPanel();
		yearField = new InputField("Year: ");
		monthField = new InputField("Month (1-12): ");
		dayField = new InputField("Day (1-31): ");

		// set container styles
		dateContainer.setBackground(CustomColor.dark_200);
		dateContainer.setLayout(new FlowLayout(FlowLayout.LEFT));

		// set input fields size
		yearField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		monthField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		dayField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		
		// add input fields to the container
		dateContainer.add(yearField);
		dateContainer.add(monthField);
		dateContainer.add(dayField);
	}
	
	private void setupTimeInputField() {
		timeContainer = new JPanel();
		hourField = new InputField("Hour (1-24): ");
		minuteField = new InputField("Minute (1-59): ");

		// set container styles
		timeContainer.setBackground(CustomColor.dark_200);
		timeContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// set input fields size
		hourField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		minuteField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		
		// add input fields to the container
		timeContainer.add(hourField);
		timeContainer.add(minuteField);
	}
	
	private void setupFormActions() {
		actionsContainer = new JPanel();
		actionsContainer.setBackground(CustomColor.dark_200);
		actionsContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		submitButton = new RoundedButton("Submit");
		submitButton.setOriginalBackgroundColor(CustomColor.white);
		submitButton.setHoverBackgroundColor(CustomColor.dark_400);
		submitButton.setForegroundDefault(CustomColor.dark_200);
		submitButton.setForegroundHover(CustomColor.white);
		submitButton.setBorder(new EmptyBorder(10, 25, 10, 25));
		
		actionsContainer.add(submitButton);
	}

}
