package model.time_range;

import java.time.LocalDate;

public class TimeRangeTypeTwo implements TimeRange {

    private final Integer numberOfDaysFromDate;
    private final LocalDate date;

    public TimeRangeTypeTwo(Integer numberOfDaysFromDate, LocalDate date) {
        this.numberOfDaysFromDate = numberOfDaysFromDate;
        this.date = date;
    }

    @Override
    public LocalDate getStartDate() {
        return date;
    }

    @Override
    public LocalDate getEndDate() {
        return date.plusDays(numberOfDaysFromDate);
    }
}
