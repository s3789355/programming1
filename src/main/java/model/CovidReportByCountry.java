package model;

import model.time_range.TimeRange;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CovidReportByCountry {

    private final List<CovidReportByDate> reportByDates;
    private final Country country;

    public CovidReportByCountry(Country country) {
        this.country = country;
        this.reportByDates = new ArrayList<>();
    }

    public List<CovidReportByDate> filterByTimeRange(TimeRange timeRange) {
        LocalDate startDate = timeRange.getStartDate();
        LocalDate endDate = timeRange.getEndDate();
        return reportByDates.stream().filter(covidReportByDate -> {
            LocalDate date = covidReportByDate.getDate();
            return (date.isAfter(startDate) && date.isBefore(endDate)) || date.isEqual(startDate) || date.isEqual(endDate);
        }).collect(Collectors.toList());
    }

    public void sortByDateIncrease() {
        reportByDates.sort(Comparator.comparing(CovidReportByDate::getDate));
    }

    public void addCovidReportByDate(CovidReportByDate covidReportByDate) {
        reportByDates.add(covidReportByDate);
    }

}
