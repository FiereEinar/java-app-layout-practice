package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import model.DateValues;
import model.Task;
import model.TaskManager;

public class TaskDAO {

  TaskManager tasks;
  String tasksFilename = "test.txt";
  
  public TaskDAO(TaskManager tm) {
    this.tasks = tm;

    initialize();
  }

  public Boolean saveTask(Task task) {

    try {
      FileWriter fw = new FileWriter(tasksFilename);

      DateValues date = new DateValues(task.deadline);
      String formattedTaskString = String.format(
          "%s,%s,%d,%d,%d,%d,%d,%s",
          task.title, task.description, date.month, date.day, date.hour, date.minute, date.second, task.finished);

      System.out.println(formattedTaskString);

      fw.append(formattedTaskString);

      fw.close();
    } catch (IOException e) {
      System.out.println("Failed to open tasks file");
      e.printStackTrace();
    }

    return true;
  }
  
  public void initialize() {
    if (createFiles())
      return;

    readFileData();
  }
  
  private void readFileData() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(tasksFilename));
      String line = "";
      
      while ((line = br.readLine()) != null) {
        String[] taskData = line.split(",");

        Calendar deadline = Calendar.getInstance();
        deadline.set(Calendar.YEAR, Integer.parseInt(taskData[2]));
        deadline.set(Calendar.MONTH, Integer.parseInt(taskData[3]));
        deadline.set(Calendar.DAY_OF_MONTH, Integer.parseInt(taskData[4]));
        deadline.set(Calendar.HOUR, Integer.parseInt(taskData[5]));
        deadline.set(Calendar.MINUTE, Integer.parseInt(taskData[6]));

        Task task = new Task(taskData[0], taskData[1], Boolean.parseBoolean(taskData[7]), deadline);

        this.tasks.tasks.add(task);
      }

      br.close();
    } catch (IOException e) {
      System.out.println("Failed to read existing saved tasks data");
      e.printStackTrace();
    }
  }

  private Boolean createFiles() {
    try {

      File file = new File(tasksFilename);
      return file.createNewFile();

    } catch (IOException e) {
      System.out.println("Failed to create tasks file");
      e.printStackTrace();
      return false;
    }
  }
  
}
