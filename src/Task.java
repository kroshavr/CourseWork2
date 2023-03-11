import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private Type taskType;
    private LocalDateTime dateTime;
    private final int id;
    static int counter = 0;

    public Task(String title, String description, Type taskType, LocalDateTime dateTime) throws IncorrectArgumentExeption {
        this.title = ValidateUtil.checkString(title);
        this.description = ValidateUtil.checkString(description);
        this.taskType = taskType;
        this.dateTime = dateTime;
        this.id = ++counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getTaskType() {
        return taskType;
    }

    public void setTaskType(Type taskType) {
        this.taskType = taskType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId() && Objects.equals(getTitle(), task.getTitle()) && Objects.equals(getDescription(), task.getDescription()) && Objects.equals(getTaskType(), task.getTaskType()) && Objects.equals(getDateTime(), task.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getTaskType(), getDateTime(), getId());
    }

    @Override
    public String toString() {
        return "{title=" + title +
                ", description=" + description +
                ", taskType=" + taskType +
                ", firstDateTime=" + dateTime +
                ", id=" + id;
    }
}
