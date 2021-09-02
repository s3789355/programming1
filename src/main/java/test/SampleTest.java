package test;

import controller.CovidReportController;
import model.ResultTable;
import model.enumm.GroupMethod;
import model.enumm.ReportMetric;
import model.enumm.WayOfCalculation;
import model.time_range.TimeRangeTypeOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SampleTest {

//    public static void main(String[] args) {
//        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
//        CovidReportController covidReportController = new CovidReportController();
//        List<ResultTable> resultTables = covidReportController.doReport("Algeria", "Africa",
//                new TimeRangeTypeOne(LocalDate.parse("02/02/2021", FORMATTER), LocalDate.parse("05/02/2021", FORMATTER)),
//                0, GroupMethod.GROUPS, ReportMetric.TOTAL_NEW_CASES, WayOfCalculation.NEW_TOTAL);
//        System.out.println(resultTables);
//    }

}
