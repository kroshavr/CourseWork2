public enum Periodicity {
    ONETIME(0),
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    YEARLY(4);

    private final int periodicity;

    Periodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public int getPeriodicity() {
        return periodicity;
    }
}
