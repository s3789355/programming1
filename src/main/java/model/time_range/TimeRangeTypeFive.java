package model.time_range;

import java.time.LocalDate;

public class TimeRangeTypeFive implements TimeRange {

    private final Integer numberOfWeeksToDate;
    private final LocalDate date;

    public TimeRangeTypeFive(Integer numberOfWeeksToDate, LocalDate date) {
        this.numberOfWeeksToDate = numberOfWeeksToDate;
        this.date = date;
    }

    @Override
    public LocalDate getStartDate() {
        return date.minusWeeks(numberOfWeeksToDate);
    }

    @Override
    public LocalDate getEndDate() {
        return date;
    }

}
