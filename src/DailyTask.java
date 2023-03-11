import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class DailyTask extends Task implements DateInterface {
    private final Periodicity daily;
    public DailyTask(String title, String description, Type type, LocalDateTime dateTime, Periodicity daily) throws IncorrectArgumentExeption {
        super(title, description, type, dateTime);
        this.daily = Periodicity.DAILY;
    }

    public Periodicity getDaily() {
        return daily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyTask)) return false;
        if (!super.equals(o)) return false;
        DailyTask dailyTask = (DailyTask) o;
        return getDaily() == dailyTask.getDaily();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDaily());
    }

    @Override
    public boolean appearsIn(LocalDateTime localDateTime) {
        return getDateTime().toLocalDate().equals(localDateTime.toLocalDate());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", daily=" + daily + "}";
    }
}
