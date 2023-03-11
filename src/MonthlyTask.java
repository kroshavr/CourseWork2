import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class MonthlyTask extends Task implements DateInterface{
    private final Periodicity monthly;
    public MonthlyTask(String title, String description, Type type, LocalDateTime dateTime, Periodicity monthly) throws IncorrectArgumentExeption {
        super(title, description, type, dateTime);
        this.monthly = Periodicity.MONTHLY;
    }

    public Periodicity getMonthly() {
        return monthly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthlyTask)) return false;
        if (!super.equals(o)) return false;
        MonthlyTask that = (MonthlyTask) o;
        return getMonthly() == that.getMonthly();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonthly());
    }

    @Override
    public boolean appearsIn(LocalDateTime localDateTime) {
        return getDateTime().getDayOfMonth() == localDateTime.getDayOfMonth();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", monthly=" + monthly + "}";
    }
}
