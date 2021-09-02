package model;

public class ResultTable {

    private String range;
    private Long value;

    public ResultTable() {

    }

    public ResultTable(String range, Long value) {
        this.range = range;
        this.value = value;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getRange() {
        return range;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ResultTable{" +
                "range='" + range + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
