package rs.raf.gerumap.log.model;

public enum Severity {
    ERROR      ("Error"),
    INFORMATION("Info"),
    WARNING    ("Warning");

    private String type;

    Severity(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
