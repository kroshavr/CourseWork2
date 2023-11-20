import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class OneTimeTask extends Task implements DateInterface {
    private final Periodicity oneTime;
    public OneTimeTask(String title, String description, Type type, LocalDateTime dateTime, Periodicity oneTime) throws IncorrectArgumentExeption {
        super(title, description, type, dateTime);
        this.oneTime = Periodicity.ONETIME;
    }

    public Periodicity getOneTime() {
        return oneTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneTimeTask)) return false;
        if (!super.equals(o)) return false;
        OneTimeTask that = (OneTimeTask) o;
        return getOneTime() == that.getOneTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOneTime());
    }

    @Override
    public boolean appearsIn(LocalDateTime localDateTime) {
        return getDateTime().toLocalDate().equals(localDateTime.toLocalDate());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", oneTime=" + oneTime + "}";
    }
}
