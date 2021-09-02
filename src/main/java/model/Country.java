package model;

public class Country {

    private String isoCode;
    private String location;
    private String continent;
    private Long population;

    public Country(String isoCode, String location, String continent, Long population) {
        this.isoCode = isoCode;
        this.location = location;
        this.continent = continent;
        this.population = population;
    }

}
