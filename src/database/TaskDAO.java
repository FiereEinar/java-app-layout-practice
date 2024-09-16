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

  private final TaskManager tasks;
  private final String directory = "storage";
  private final String originalTasksFilename = "test.csv";
  private final String tasksFilename = directory + "/" + originalTasksFilename;
  private final String tempFilename = directory + "/temp___" + originalTasksFilename;
  
  public TaskDAO(TaskManager tm) {
    this.tasks = tm;

    initialize();
  }

  /**
   * Saves a single Task in a file storage
   * @param task
   * @return Boolean - whether the Task has been saved succesfully
   */
  public Boolean saveTask(Task task) {

    try {
      
      FileWriter fw = new FileWriter(tasksFilename, true);
      fw.append(convertTaskToFileString(task));
      fw.close();

    } catch (IOException e) {
      System.out.println("Failed to add task");
      e.printStackTrace();
    }

    return true;
  }

  /**
   * Deletes an item in the storage with the given id
   * @param id
   * @return Boolean - whether the task has been successfully deleted
   */
  public Boolean deleteTask(int id) {

    try {
      // reader for the file
      BufferedReader br = new BufferedReader(new FileReader(tasksFilename));
      String line = "";

      // setup files
      createFile(tempFilename);

      // file writer for temp file
      FileWriter fw = new FileWriter(tempFilename, true);

      while ((line = br.readLine()) != null) {
        Task task = convertFileDataToTask(line);

        // dont include the deleted task to temp file
        if (task.id != id) {
          fw.append(convertTaskToFileString(task));
        }
      }

      br.close();
      fw.close();

      // swap the temp file and original file
      File original = new File(tasksFilename);
      original.delete();
      new File(tempFilename).renameTo(original);

    } catch (IOException e) {
      System.out.println("Failed to delete an item");
      e.printStackTrace();
    }

    return true;
  }

  /**
   * Updates a task inside the file storage
   * @param taskID int - ID of the task to be updated
   * @param updatedTask Task - an updated version of the task
   * @return
   */
  public Boolean updateTask(int taskID, Task updatedTask) {
    try {
      // reader for the file
      BufferedReader br = new BufferedReader(new FileReader(tasksFilename));
      String line = "";

      // setup files
      createFile(tempFilename);

      // file writer for temp file
      FileWriter fw = new FileWriter(tempFilename, true);

      while ((line = br.readLine()) != null) {
        Task task = convertFileDataToTask(line);
        
        if (task.id != taskID) {
          fw.append(convertTaskToFileString(task));
        } else {
          fw.append(convertTaskToFileString(updatedTask));
        }
      }

      br.close();
      fw.close();

      // swap the temp file and original file
      File original = new File(tasksFilename);
      original.delete();
      new File(tempFilename).renameTo(original);

    } catch (IOException e) {
      System.out.println("Failed to update an item");
      e.printStackTrace();
    }

    return true;
  }
  
  /*
   * Updates the "finished" Boolean value of a task in the file
   */
  public Boolean updateTaskFinishedStatus(int taskID, Boolean finished) {
    try {
      // reader for the file
      BufferedReader br = new BufferedReader(new FileReader(tasksFilename));
      String line = "";

      // setup files
      createFile(tempFilename);

      // file writer for temp file
      FileWriter fw = new FileWriter(tempFilename, true);

      while ((line = br.readLine()) != null) {
        Task task = convertFileDataToTask(line);

        if (task.id == taskID)
          task.finished = finished;

        fw.append(convertTaskToFileString(task));
      }

      br.close();
      fw.close();

      // swap the temp file and original file
      File original = new File(tasksFilename);
      original.delete();
      new File(tempFilename).renameTo(original);

    } catch (IOException e) {
      System.out.println("Failed to delete an item");
      e.printStackTrace();
    }

    return true;
  }

  /**
   * Converts a BufferedReader.readLine() into a Task
   * @param filedata
   * @return Task
   */
  private Task convertFileDataToTask(String filedata) {
    String[] taskData = filedata.split(",");

    Calendar deadline = Calendar.getInstance();
    deadline.set(Calendar.YEAR, Integer.parseInt(taskData[2]));
    deadline.set(Calendar.MONTH, Integer.parseInt(taskData[3]));
    deadline.set(Calendar.DAY_OF_MONTH, Integer.parseInt(taskData[4]));
    deadline.set(Calendar.HOUR, Integer.parseInt(taskData[5]));
    deadline.set(Calendar.MINUTE, Integer.parseInt(taskData[6]));

    return new Task(taskData[0], taskData[1], Boolean.parseBoolean(taskData[7]), deadline,
        Integer.parseInt(taskData[8]));
  }
  
  /**
   * Converts a Task values into a csv format
   * @param task
   * @return String in csv format
   */
  private String convertTaskToFileString(Task task) {
    DateValues date = new DateValues(task.deadline);

    return String.format(
      "%s,%s,%d,%d,%d,%d,%d,%s,%d\n",
      task.title.replace(",", ""),
      task.description.replace(",", ""),
      date.year,
      date.month,
      date.day,
      date.hour,
      date.minute,
      task.finished,
      task.id
    );
  }
  
  /**
   * Creates the storage directory and files to store data,
   * if there's an existing file, it reads it
   */
  public void initialize() {
    createDir(directory);
    if (createFile(tasksFilename))
      return;

    readFileData();
  }
  
  /**
   * Reads the tasks data inside and existing file
   */
  private void readFileData() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(tasksFilename));
      String line = "";

      while ((line = br.readLine()) != null) {
        Task task = convertFileDataToTask(line);
        this.tasks.tasks.add(task);
      }

      br.close();
    } catch (IOException e) {
      System.out.println("Failed to read existing saved tasks data");
      e.printStackTrace();
    }
  }

  /**
   * Creates a file
   * @return Boolean - whether the file has been created 
   */
  private Boolean createFile(String filename) {
    try {

      File file = new File(filename);
      return file.createNewFile();

    } catch (IOException e) {
      System.out.println("Failed to create file");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Creates a directory
   * @return Boolean - whether the directory has been created 
   */
  private Boolean createDir(String dir) {
    try {

      return new File(dir).mkdir();

    } catch (SecurityException e) {
      System.out.println("Failed to create tasks file");
      e.printStackTrace();
      return false;
    }
  }
  
}
