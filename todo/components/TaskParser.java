package todo.components;

import todo.task.Task;
import todo.task.Urgency;
import todo.task.UrgencyFactory;

import java.io.*;
import java.util.*;

public class TaskParser {

  private String filename;

  public TaskParser(String filename) {
    this.filename = filename;
  }

  public Task[] loadTasks() {
    BufferedReader reader = null;
    List<Task>     taskList = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader(new File(filename)));

      String line;
      while ((line = reader.readLine()) != null) {
        Task task = parseStringToTask(line);
        if (task != null) {
          taskList.add(task);
        }
      }

    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    Task[] arr = new Task[taskList.size()];
    arr = taskList.toArray(arr);
    return arr;
  }

  public void saveTasks(Task[] tasks) {
    BufferedWriter writer = null;

    try {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filename))));

      for (Task task : tasks) {
        writer.write(parseTaskToString(task));
        writer.newLine();
      }

    } catch (Exception ex) {

      ex.printStackTrace();
      System.exit(1);

    } finally {
      try {
        writer.flush();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private String parseTaskToString(Task task) {
    return "|" + task.getLevel() + "| |" + task.getTitle() + "| |" + task.getDescription() + "|";
  }

  private Task parseStringToTask(String line) {
    // "<urgency>" "<title>" "<description>"

    String[] tokens = getTokens(line);

    if (tokens.length > 3) {
        return null;
    }

    Urgency level = null;
    try {
      level = UrgencyFactory.getInstance().getUrgency(tokens[0]);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }

    return new Task(level, tokens[1], tokens.length > 2 ? tokens[2] : null);
  }

  private String[] getTokens(String line) {
    ArrayList<String> tokens = new ArrayList<>();

    boolean isToken = false;
    int a = -1, b;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '|') {
        isToken = !isToken;
        if (isToken) {
          a = i;
        } else {
          b = i;
          tokens.add(line.substring(a + 1, b));
        }
      }
    }

    String[] arr = new String[tokens.size()];
    arr = tokens.toArray(arr);
    return arr;
  }

}
