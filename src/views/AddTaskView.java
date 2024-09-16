package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AddTaskController;
import database.TaskDAO;
import main.CustomColor;
import main.Window;
import model.DateValues;
import model.Task;
import model.TaskManager;
import ui.Input;
import ui.InputField;
import ui.NormalMutedText;
import ui.RoundedButton;

public class AddTaskView extends MainLayout {

	private static final long serialVersionUID = 1L;
	private final int dateInputWidth = 150;
	
	JPanel formContainer;
	
	public InputField titleField;
	public InputField descriptionField;
	
	JPanel dateContainer;
	
	public InputField yearField;
	public InputField monthField;
	public InputField dayField;
	
	JPanel timeContainer;
	
	public InputField hourField;
	public InputField minuteField;
	
	JPanel actionsContainer;
	
	RoundedButton submitButton;
	
	AddTaskController controller;

	Boolean editingMode = false;

	int updatedTaskID;
	
	public AddTaskView(Window window, TaskManager tm, TaskDAO taskDAO) {
		super(window, tm, taskDAO);
		this.controller = new AddTaskController(this);
	}
	
	public void render() {
		this.removeAll();
		
		formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
		formContainer.setBackground(CustomColor.dark_200);
		
		titleField = new InputField("Title: ");
		descriptionField = new InputField("Description: ");
		
		// TODO: refactor this extra container
		// putting the title and description inside a container so that is has the same alignment as the rest, component margin issue
		NormalMutedText deadlineLabel = new NormalMutedText("Deadline for this task: ");
		JPanel c = new JPanel();
		c.setBackground(CustomColor.dark_200);
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.add(deadlineLabel);

		setupDateInputField();
		setupTimeInputField();
		setupFormActions();
		setDefaultValues();
		
		// add the fields to the form container
		formContainer.add(titleField);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(descriptionField);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(c);
		formContainer.add(dateContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(timeContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		formContainer.add(actionsContainer);
		formContainer.add(Box.createRigidArea(new Dimension(0, 10)));

		this.add(formContainer);

		resetValues();
	}
	
	private void setupDateInputField() {
		dateContainer = new JPanel();
		yearField = new InputField("Year: ");
		monthField = new InputField("Month (1-12): ");
		dayField = new InputField("Day (1-31): ");

		// set container styles
		dateContainer.setBackground(CustomColor.dark_200);
		// dateContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		dateContainer.setLayout(new GridLayout(1, 3, 10, 0));

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
		JLabel placeholder = new JLabel();

		// set container styles
		timeContainer.setBackground(CustomColor.dark_200);
		timeContainer.setLayout(new GridLayout(1, 3, 10, 0));
		
		// set input fields size
		hourField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		minuteField.input.setPreferredSize(new Dimension(dateInputWidth, Input.height));
		
		// add input fields to the container
		timeContainer.add(hourField);
		timeContainer.add(minuteField);
		timeContainer.add(placeholder);
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
		submitButton.addActionListener(e -> {
			if (editingMode) {
				controller.handleEditTask(updatedTaskID);
			} else {
				controller.handleAddTask();
			}
		});
		
		actionsContainer.add(submitButton);
	}
	
	private void setDefaultValues() {
		Calendar date = Calendar.getInstance();
		
		yearField.input.setText(String.valueOf(date.get(Calendar.YEAR)));
		monthField.input.setText(String.valueOf(date.get(Calendar.MONTH) + 1));
		dayField.input.setText(String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
	}
	
	public String getTitle() {
		return this.titleField.input.getText();
	}
	
	public String getDescription() {
		return this.descriptionField.input.getText();
	}
	
	public int getYear() {
		return Integer.parseInt(this.yearField.input.getText());
	}
	
	public int getMonth() {
		return Integer.parseInt(this.monthField.input.getText()) - 1;
	}
	
	public int getDayOfMonth() {
		return Integer.parseInt(this.dayField.input.getText());
	}
	
	public int getHour() {
		return Integer.parseInt(this.hourField.input.getText());
	}
	
	public int getMinutes() {
		return Integer.parseInt(this.minuteField.input.getText());
	}

	public DateValues getDateValue() {
		return new DateValues(getYear(), getMonth(), getDayOfMonth(), getHour(), getMinutes());
	}

	public void resetValues() {
		editingMode = false;
		setDefaultValues();
		this.titleField.input.setText("");
		this.descriptionField.input.setText("");
		this.hourField.input.setText("");
		this.minuteField.input.setText("");
	}

	public void setValues(Task task) {
		editingMode = true;
		updatedTaskID = task.id;
		DateValues date = new DateValues(task.deadline);
		this.titleField.input.setText(task.title);
		this.descriptionField.input.setText(task.description);

		this.yearField.input.setText("" + date.year);
		this.monthField.input.setText("" + (date.month + 1));
		this.dayField.input.setText("" + date.day);
		this.hourField.input.setText("" + date.hour);
		this.minuteField.input.setText("" + date.minute);
	}

}
