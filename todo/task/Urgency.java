package todo.task;

import java.awt.*;

public enum Urgency {

  Lowest("Lowest", new Color(0, 150, 0)),
  Low("Low", new Color(120, 200, 120)),
  Medium("Medium", new Color(220, 220, 0)),
  High("High", new Color(250, 150, 0)),
  Highest("Highest", new Color(150, 0, 0));

  private String name;
  private Color color;

  Urgency(String name, Color color) {
    this.name = name;
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public String toString() {
    return name;
  }
}
