package todo.task;

public class UrgencyFactory {

  private static UrgencyFactory INSTANCE;

  private UrgencyFactory() {}

  public static UrgencyFactory getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new UrgencyFactory();
    }
    return INSTANCE;
  }

  public Urgency getUrgency(String name) throws IllegalArgumentException {
    switch (name) {
      case "Lowest":
        return Urgency.Lowest;
      case "Low":
        return Urgency.Low;
      case "Medium":
        return Urgency.Medium;
      case "High":
        return Urgency.High;
      case "Highest":
        return Urgency.Highest;
      default:
        throw new IllegalArgumentException(String.format("The %s urgency level doesn't exist!", name));
    }
  }
}
