package controller;

import exception.CovidException;
import model.CovidReport;
import model.CovidReportByCountry;
import model.CovidReportByDate;
import model.ResultTable;
import model.enumm.GroupMethod;
import model.enumm.ReportMetric;
import model.enumm.WayOfCalculation;
import model.time_range.TimeRange;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CovidReportController {

    private final CovidReport covidReport;

    public CovidReportController() {
        covidReport = new CovidReport();
    }

    public Map<String, String> getCountries() {
        return covidReport.getCountries();
    }

    public Map<String, Set<String>> getContinents() {
        return covidReport.getContinents();
    }

    private List<List<CovidReportByDate>> divideByDays(List<CovidReportByDate> covidReportByDates, Integer numberOfGroups, GroupMethod groupMethod) {
        List<List<CovidReportByDate>> ans = new ArrayList<>();
        int numberOfDays = covidReportByDates.size();
        if (numberOfGroups == 0) {
            throw new CovidException("Number of groups must greater than 0");
        }
        if (numberOfDays % numberOfGroups != 0) {
            throw new CovidException("It is not possible to divide groups equally");
        }
        if (numberOfDays < numberOfGroups) {
            throw new CovidException("Number of groups must less than number of days");
        }
        for (int i = 0; i < covidReportByDates.size(); i += numberOfGroups) {
            ans.add(covidReportByDates.subList(i, i + numberOfGroups));
        }
        return ans;
    }

    private List<List<CovidReportByDate>> divideByGroups(List<CovidReportByDate> covidReportByDates, Integer numberOfGroups, GroupMethod groupMethod) {
        List<List<CovidReportByDate>> ans = new ArrayList<>();
        int siz = covidReportByDates.size();
        if (siz == 0) return new ArrayList<>();
        LocalDate fromDate = covidReportByDates.get(0).getDate();
        LocalDate toDate = covidReportByDates.get(siz - 1).getDate();
        int nod = (int) Math.abs(Duration.between(toDate.atStartOfDay(), fromDate.atStartOfDay()).toDays()) + 1;
        if (numberOfGroups == 0) {
            numberOfGroups = siz;
        }
        if (nod < numberOfGroups) {
            throw new CovidException("Number of group must less than number of days");
        }
        int numberOfElementsPerGroup = nod / numberOfGroups;
        long rem = nod % numberOfGroups;
        int currentIndex = 0;
        while (currentIndex < siz) {
            List<CovidReportByDate> curr = new ArrayList<>(covidReportByDates.subList(currentIndex, currentIndex + numberOfElementsPerGroup));
            currentIndex += numberOfElementsPerGroup;
            if (rem > 0) {
                curr.add(covidReportByDates.get(currentIndex));
                currentIndex++;
                --rem;
            }
            ans.add(curr);
        }
        return ans;
    }

    private List<List<CovidReportByDate>> divide(List<CovidReportByDate> covidReportByDates, Integer numberOfGroups, GroupMethod groupMethod) {
        if (groupMethod == GroupMethod.DAYS) {
            return divideByDays(covidReportByDates, numberOfGroups, groupMethod);
        } else if (groupMethod == GroupMethod.GROUPS) {
            return divideByGroups(covidReportByDates, numberOfGroups, groupMethod);
        }
        return new ArrayList<>();
    }

    private ResultTable computeOneGroup(List<CovidReportByDate> group, ReportMetric reportMetric) {
        int siz = group.size();
        if (siz == 0) {
            return new ResultTable("@@", 0L);
        }
        ResultTable resultTable = new ResultTable();
        LocalDate startDate = group.get(0).getDate();
        LocalDate endDate = group.get(siz - 1).getDate();
        if (startDate.isEqual(endDate)) {
            resultTable.setRange(startDate.toString());
        } else {
            resultTable.setRange(startDate + " - " + endDate);
        }
        long value = -1;
        switch (reportMetric) {
            case TOTAL_NEW_CASES: {
                value = group.stream().map(CovidReportByDate::getNewCases).mapToLong(Long::longValue).sum();
                break;
            }
            case TOTAL_DEATH_CASES: {
                value = group.stream().map(CovidReportByDate::getNewDeaths).mapToLong(Long::longValue).sum();
                break;
            }
            case TOTAL_PEOPLE_VACCINATED: {
                value = group.stream().map(CovidReportByDate::getPeopleVaccinated).mapToLong(Long::longValue).sum();
                break;
            }
        }
        resultTable.setValue(value);
        return resultTable;
    }

    private List<ResultTable> compute(List<List<CovidReportByDate>> groups, ReportMetric reportMetric, WayOfCalculation wayOfCalculation) {
        List<ResultTable> ans = new ArrayList<>();
        long sumUp = 0;
        for (List<CovidReportByDate> group : groups) {
            ResultTable resultTable = computeOneGroup(group, reportMetric);
            if (wayOfCalculation == WayOfCalculation.UP_TO) {
                resultTable.setValue(resultTable.getValue() + sumUp);
                sumUp = resultTable.getValue();
            }
            ans.add(resultTable);
        }
        return ans;
    }

    public List<ResultTable> doReport(String country, String continent, TimeRange timeRange,
                                      Integer numberOfGroups, GroupMethod groupMethod, ReportMetric metric, WayOfCalculation wayOfCalculation) {
        CovidReportByCountry covidReportByCountry = covidReport.getCovidReportByCountry(country);
        List<CovidReportByDate> covidReportByDates = covidReportByCountry.filterByTimeRange(timeRange);
        List<List<CovidReportByDate>> covidReportDivided = divide(covidReportByDates, numberOfGroups, groupMethod);
        return compute(covidReportDivided, metric, wayOfCalculation);
    }

}
