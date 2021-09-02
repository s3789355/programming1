package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSVLine {

    private final String isoCode;
    private final String continent;
    private final String location;
    private final String date;
    private final String newCases;
    private final String newDeaths;
    private final String peopleVaccinated;
    private final String population;

    public CSVLine(String[] spt) {
        isoCode = spt[0].trim();
        continent = spt[1].trim();
        location = spt[2].trim();
        date = spt[3].trim();
        newCases = spt[4].trim();
        newDeaths = spt[5].trim();
        peopleVaccinated = spt[6].trim();
        population = spt[7].trim();
    }

    public String getIsoCode() {
        if(isoCode.isBlank()) {
            return "Other";
        }
        return isoCode;
    }

    public String getContinent() {
        if(continent.isBlank()) {
            return "Other";
        }
        return continent;
    }

    public String getLocation() {
        if(location.isBlank()) {
            return "Other";
        }
        return location;
    }

    public LocalDate getDate() {
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(date, FORMATTER);
    }

    public Long getNewCases() {
        if (newCases.isBlank()) {
            return 0L;
        }
        return Long.parseLong(newCases);
    }

    public Long getNewDeaths() {
        if (newDeaths.isBlank()) {
            return 0L;
        }
        return Long.parseLong(newDeaths);
    }

    public Long getPeopleVaccinated() {
        if (peopleVaccinated.isBlank()) {
            return 0L;
        }
        return Long.parseLong(peopleVaccinated);
    }

    public Long getPopulation() {
        if (population.isBlank()) {
            return 0L;
        }
        return Long.parseLong(population);
    }

    @Override
    public String toString() {
        return "CSVLine{" +
                "isoCode='" + isoCode + '\'' +
                ", continent='" + continent + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", newCases='" + newCases + '\'' +
                ", newDeaths='" + newDeaths + '\'' +
                ", peopleVaccinated='" + peopleVaccinated + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
