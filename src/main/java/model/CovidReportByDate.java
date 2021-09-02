package model;

import java.time.LocalDate;

public class CovidReportByDate {

    private final LocalDate date;
    private final Long newCases;
    private final Long newDeaths;
    private final Long peopleVaccinated;

    public CovidReportByDate(LocalDate date, Long newCases, Long newDeaths, Long peopleVaccinated) {
        this.date = date;
        this.newCases = newCases;
        this.newDeaths = newDeaths;
        this.peopleVaccinated = peopleVaccinated;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getNewCases() {
        return newCases;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public Long getPeopleVaccinated() {
        return peopleVaccinated;
    }
}
