package model.time_range;

import java.time.LocalDate;

public class TimeRangeTypeFour implements TimeRange {

    private final Integer numberOfDaysToDate;
    private final LocalDate date;

    public TimeRangeTypeFour(Integer numberOfDaysToDate, LocalDate date) {
        this.numberOfDaysToDate = numberOfDaysToDate;
        this.date = date;
    }

    @Override
    public LocalDate getStartDate() {
        return date.minusDays(numberOfDaysToDate);
    }

    @Override
    public LocalDate getEndDate() {
        return date;
    }

}
