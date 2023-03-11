import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class YearlyTask extends Task implements DateInterface{
    private final Periodicity yearly;
    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime, Periodicity yearly) throws IncorrectArgumentExeption {
        super(title, description, type, dateTime);
        this.yearly = Periodicity.YEARLY;
    }

    public Periodicity getYearly() {
        return yearly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YearlyTask)) return false;
        if (!super.equals(o)) return false;
        YearlyTask that = (YearlyTask) o;
        return getYearly() == that.getYearly();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getYearly());
    }

    @Override
    public boolean appearsIn(LocalDateTime localDateTime) {
        return getDateTime().getDayOfYear() == localDateTime.getDayOfYear();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", yearly=" + yearly + "}";
    }
}
