package todo.task;

public class Task {

  protected Urgency level;
  protected String title;
  protected String description;
  protected Status status;

  public Task(Urgency level, String title)
    {
      this(level, title, null);
    }

  public Task(Urgency level, String title, String description)
    {
      this.level = level;
      this.title = title;
      this.description = description;
      this.status = Status.Open;
    }

  public Urgency getLevel()
    {
      return level;
    }

  public void setLevel(Urgency level)
    {
      this.level = level;
    }

  public String getTitle()
    {
      return title;
    }

  public void setTitle(String title)
    {
      this.title = title;
    }

  public String getDescription()
    {
      return description;
    }

  public void setDescription(String description)
    {
      this.description = description;
    }

  public Status getStatus()
    {
      return status;
    }

  public void setStatus(Status status)
    {
      this.status = status;
    }
}
