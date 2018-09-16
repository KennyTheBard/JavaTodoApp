package todo.components;

import todo.task.Urgency;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TaskDialog extends JDialog {

  private Urgency level;
  private String  title;
  private String  description;

  private JComboBox<Urgency> levelBox;
  private JTextField         titleField;
  private JTextField         descriptionField;

  public TaskDialog(Frame frame, String s) {
    super(frame, s, ModalityType.APPLICATION_MODAL);

    setLayout(new GridBagLayout());
    setPreferredSize(new Dimension(400, 200));

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

    JPanel btnPanel = new JPanel();

    JButton btnAccept = new JButton("Accept");
    btnAccept.addActionListener(
        actionEvent -> accept()
    );
    btnPanel.add(btnAccept);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(
        actionEvent -> cancel()
    );
    btnPanel.add(btnCancel);

    levelBox = new JComboBox<>(
        new Urgency[] {
            Urgency.Lowest, Urgency.Low, Urgency.Medium, Urgency.High, Urgency.Highest
        }
    );
    levelBox.setSelectedItem(null);
    mainPanel.add(levelBox);

    JPanel titlePanel = new JPanel(new FlowLayout());
    JLabel titleLabel = new JLabel("Title:");
    titlePanel.add(titleLabel);
    titleField = new JTextField(50);
    titlePanel.add(titleField);
    mainPanel.add(titlePanel);

    JPanel descriptionPanel = new JPanel(new FlowLayout());
    JLabel descriptionLabel = new JLabel("Description:");
    descriptionPanel.add(descriptionLabel);
    descriptionField = new JTextField(100);
    descriptionPanel.add(descriptionField);
    mainPanel.add(descriptionPanel);

    mainPanel.add(btnPanel);

    getContentPane().add(mainPanel);
    pack();
  }

  private void accept() {
    level = (Urgency) levelBox.getSelectedItem();
    title = titleField.getText();
    description = descriptionField.getText();
    setVisible(false);
  }

  private void cancel() {
    level = null;
    title = null;
    description = null;
    setVisible(false);
  }

  public Urgency getLevel()
    {
      return level;
    }

  @Override
  public String getTitle()
    {
      return title;
    }

  public String getDescription()
    {
      return description;
    }
}
