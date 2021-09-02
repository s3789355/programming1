package model.time_range;

import java.time.LocalDate;

public class TimeRangeTypeOne implements TimeRange {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public TimeRangeTypeOne(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }
}
