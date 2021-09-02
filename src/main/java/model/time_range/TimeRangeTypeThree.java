package model.time_range;

import java.time.LocalDate;

public class TimeRangeTypeThree implements TimeRange {

    private final Integer numberOfWeeksFromDate;
    private final LocalDate date;

    public TimeRangeTypeThree(Integer numberOfWeeksFromDate, LocalDate date) {
        this.numberOfWeeksFromDate = numberOfWeeksFromDate;
        this.date = date;
    }

    @Override
    public LocalDate getStartDate() {
        return date;
    }

    @Override
    public LocalDate getEndDate() {
        return date.plusWeeks(numberOfWeeksFromDate);
    }
}
