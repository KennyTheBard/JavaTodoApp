import todo.task.Task;
import todo.components.TaskDialog;
import todo.components.TaskList;
import todo.components.TaskParser;

import javax.swing.*;
import java.awt.event.*;

public class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    TaskList list = new TaskList();
    TaskParser parser = new TaskParser("tasks.txt");
    for (Task task : parser.loadTasks()) {
      list.addTask(task);
    }

    frame.getContentPane().add(list);

    JPanel btnPanel = new JPanel();

    JButton buttonAdd = new JButton("Add new todo");
    buttonAdd.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
        {
          TaskDialog dialog = new TaskDialog(frame, "Define your new todo");
          dialog.setVisible(true);
          if (dialog.getLevel() != null) {
            list.addTask(new Task(dialog.getLevel(), dialog.getTitle(), dialog.getDescription()));
          }
        }
    });
    btnPanel.add(buttonAdd);

    JButton buttonSave = new JButton("Save");
    buttonSave.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        parser.saveTasks(list.getTasks());
      }
    });
    btnPanel.add(buttonSave);

    frame.getContentPane().add(btnPanel);

    frame.setVisible(true);
  }

}
