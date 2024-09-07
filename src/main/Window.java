package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.WindowController;
import ui.SidebarButton;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String font = "Calibri";
	
	public JLabel title = new JLabel();
	private WindowController controller = new WindowController(this);
	public JPanel mainContent = new JPanel();		
	public JPanel content = new JPanel();
	
	public Window() {
		this.setVisible(true);
		this.setTitle("Layout Practice");
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		header();
		sidebar();
		mainContent();
		
//		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 10);
		System.out.println(cal.getTime());
	}
	
	private void header() {
		JPanel panel = new JPanel();
		panel.setBackground(CustomColor.dark_100);
		panel.setBorder(new EmptyBorder(10, 10, 4, 10));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel label = new JLabel("Header");
		label.setForeground(CustomColor.white);
		label.setFont(new Font(font, Font.BOLD, CustomFontSize.xlarge));
//		label.setIcon(Utils.getImageIcon("res/images/logo.png", 40, 40));
		panel.add(label);
		this.add(panel, BorderLayout.NORTH);
	}
	
	private void sidebar() {
		// sidebar container
		JPanel panel = new JPanel();
		panel.setBackground(CustomColor.dark_100);
		
		{
			// sidebar buttons container
			JPanel actionsContainer = new JPanel();
			actionsContainer.setBackground(CustomColor.dark_100);
			actionsContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
			actionsContainer.setLayout(new GridLayout(4, 1, 0, 8));
			
			SidebarButton allTasksButton = new SidebarButton("All Task");
			allTasksButton.addActionListener(e -> controller.handleAllTasks());
			
			SidebarButton addTaskButton = new SidebarButton("Add Task");
			addTaskButton.addActionListener(e -> controller.handleAddTask());
			
			SidebarButton upcomingTaskButton = new SidebarButton("Upcoming Task");
			upcomingTaskButton.addActionListener(e -> controller.handleUpcomingTasks());
			
			SidebarButton finishedTaskButton = new SidebarButton("Finished Task");
			finishedTaskButton.addActionListener(e -> controller.handleFinishedTask());

			actionsContainer.add(allTasksButton);
			actionsContainer.add(addTaskButton);
			actionsContainer.add(upcomingTaskButton);
			actionsContainer.add(finishedTaskButton);
			
			panel.add(actionsContainer);
		}
		
		this.add(panel, BorderLayout.WEST);
	}
	
	private void mainContent() {
		// center content container
		JPanel panel = new JPanel();
		panel.setBackground(CustomColor.dark_200);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		{
			// container for the content
			JPanel content = new JPanel();
			content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
			content.setAlignmentX(Component.RIGHT_ALIGNMENT);
			content.setBackground(CustomColor.dark_200);
			content.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			// title for the content
			JPanel titleContainer = new JPanel();
			titleContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			titleContainer.setBackground(CustomColor.dark_200);
			title.setFont(new Font(font, Font.PLAIN, CustomFontSize.large));
			title.setAlignmentX(Component.RIGHT_ALIGNMENT);
			title.setForeground(CustomColor.white);
			titleContainer.add(title);

			// datas inside a content container
			mainContent.setBackground(CustomColor.dark_200);
			mainContent.setBorder(new EmptyBorder(10, 10, 10, 10));
			mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));

			content.add(titleContainer);
			content.add(mainContent);
			
			panel.add(content);
		}
		
		this.add(panel, BorderLayout.CENTER);
	}
	

}
