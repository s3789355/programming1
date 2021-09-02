package model;

import exception.CovidException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class CovidReport {

    private final Map<String, CovidReportByCountry> covidReport;
    private final Map<String, String> countryMapping;
    private final Map<String, Set<String>> continentMapping;

    public CovidReport() {
        countryMapping = new HashMap<>();
        continentMapping = new HashMap<>();
        covidReport = new HashMap<>();
        readCsvInput();
        sortReportByDateIncrease();
    }

    public void readCsvInput() {
        String INPUT_FILE = "dataset";
        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
            String line = br.readLine(); // Skip first line
            line = br.readLine();
            while (line != null) {
                String[] spt = line.split(",");
                List<String> spts = new ArrayList<>(Arrays.asList(spt));
                while(spts.size() < 8) spts.add("");
                CSVLine csvLine = new CSVLine(spts.toArray(new String[0]));
                addRecord(csvLine);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new CovidException("Cannot read input file: " + INPUT_FILE);
        }
    }

    private void addRecord(CSVLine csvLine) {
        String location = csvLine.getLocation();
        if (!covidReport.containsKey(location)) {
            Country country = new Country(
                    csvLine.getIsoCode(),
                    location,
                    csvLine.getContinent(),
                    csvLine.getPopulation()
            );
            covidReport.put(location, new CovidReportByCountry(country));
            countryMapping.put(csvLine.getLocation(), csvLine.getContinent());
            continentMapping.putIfAbsent(csvLine.getContinent(), new HashSet<>());
            continentMapping.get(csvLine.getContinent()).add(csvLine.getLocation());
        }
        CovidReportByDate covidReportByDate = new CovidReportByDate(
                csvLine.getDate(),
                csvLine.getNewCases(),
                csvLine.getNewDeaths(),
                csvLine.getPeopleVaccinated()
        );
        covidReport.get(location).addCovidReportByDate(covidReportByDate);
    }

    private void sortReportByDateIncrease() {
        covidReport.keySet().forEach(isoCode -> covidReport.get(isoCode).sortByDateIncrease());
    }

    public Map<String, String> getCountries() {
        return countryMapping;
    }

    public Map<String, Set<String>> getContinents() {
        return continentMapping;
    }

    public CovidReportByCountry getCovidReportByCountry(String country) {
        return covidReport.get(country);
    }

}
