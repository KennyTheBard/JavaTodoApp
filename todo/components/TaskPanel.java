package todo.components;

import todo.task.Task;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TaskPanel extends JPanel {

  protected Task task;

  protected Border border;
  protected JCheckBox solved;
  protected JLabel title;
  protected JLabel description;

  public TaskPanel(Task task) {
    this.task = task;

    setPreferredSize(new Dimension(400, 100));
    setLayout(new GridBagLayout());

    border = new MatteBorder(5, 10, 1, 1, task.getLevel().getColor());
    setBorder(border);

    solved = new JCheckBox();
    JPanel solvedPanel = new JPanel();
    solvedPanel.setLayout(new GridBagLayout());
    solvedPanel.add(solved, new GridBagConstraints());
    add(solvedPanel, createConstraints(GridBagConstraints.BOTH, 0, 0, 0.3, 0.5, 1, 3));

    title = new JLabel("<html><body width='175px'>" + task.getTitle() + "</body></html>");
    title.setFont(new Font("SansSerif", Font.BOLD, 24));
    add(title, createConstraints(GridBagConstraints.BOTH, 1, 0, 0.5, 0.5, 1, 1));

    description = new JLabel("<html><body width='175px'>" + task.getDescription() + "</body></html>");
    description.setFont(new Font("SansSerif", Font.PLAIN, 14));
    add(description, createConstraints(GridBagConstraints.BOTH, 1, 1, 0.5, 0.5, 2, 2));

  }


  protected GridBagConstraints createConstraints(int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth, int gridheight) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = fill;
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    constraints.weightx = weightx;
    constraints.weighty = weighty;
    constraints.gridwidth = gridwidth;
    constraints.gridheight = gridheight;
    return constraints;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

}
