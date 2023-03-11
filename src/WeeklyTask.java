import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class WeeklyTask extends Task implements DateInterface{
    private final Periodicity weekly;
    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime, Periodicity weekly) throws IncorrectArgumentExeption {
        super(title, description, type, dateTime);
        this.weekly = Periodicity.WEEKLY;
    }

    public Periodicity getWeekly() {
        return weekly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeeklyTask)) return false;
        if (!super.equals(o)) return false;
        WeeklyTask that = (WeeklyTask) o;
        return getWeekly() == that.getWeekly();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeekly());
    }

    @Override
    public boolean appearsIn(LocalDateTime localDateTime) {
        return getDateTime().getDayOfWeek().equals(localDateTime.getDayOfWeek());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", weekly=" + weekly + "}";
    }
}
