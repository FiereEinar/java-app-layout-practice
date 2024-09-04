package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.WindowController;
import ui.SidebarButton;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	public String font = "Calibri";
	
	public JLabel title = new JLabel();
	private WindowController controller = new WindowController(this);
	public JPanel mainContent = new JPanel();
	
	public Window() {
		this.setVisible(true);
		this.setTitle("Layout Practice");
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		mainContent = new JPanel();

		header();
		sidebar();
		mainContent();
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
		JPanel panel = new JPanel();
		panel.setBackground(CustomColor.dark_100);
		
		{
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
		JPanel panel = new JPanel();
		panel.setBackground(CustomColor.dark_200);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		{
			mainContent.setBackground(CustomColor.dark_200);
			mainContent.setBorder(new EmptyBorder(10, 10, 10, 10));
//			mainContent.setLayout(new FlowLayout(FlowLayout.LEFT));
			mainContent.setLayout(new GridLayout(2, 1));
			
			title.setFont(new Font(font, Font.PLAIN, CustomFontSize.large));
			title.setForeground(CustomColor.white);
			mainContent.add(title);
			
			panel.add(mainContent);
		}
		
		this.add(panel, BorderLayout.CENTER);
	}
	

}
