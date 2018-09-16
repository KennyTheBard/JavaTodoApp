package todo.components;

import todo.task.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class TaskList extends JScrollPane {

  protected JPanel list;

  public TaskList() {
    list = new JPanel();
    list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    setViewportView(list);
    setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    getVerticalScrollBar().setUnitIncrement(10);
  }

  public void addTask(Task task) {
    JPanel container = new JPanel();
    container.setBorder(new EmptyBorder(10, 10, 10, 10));
    container.add(new TaskPanel(task));
    list.add(container);
    revalidate();
    repaint();
  }

  public Task[] getTasks() {
    ArrayList<Task> tasks = new ArrayList<>();
    for (Component panel :  list.getComponents()) {
      tasks.add(((TaskPanel) ((JPanel) panel).getComponent(0)).getTask());
    }
    Task[] arr = new Task[tasks.size()];
    arr = tasks.toArray(arr);
    return arr;
  }
}
