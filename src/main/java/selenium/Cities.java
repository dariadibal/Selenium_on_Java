package selenium;

public enum Cities {
    CALIFORNIA("California"),
    FLORIDA("Florida"),
    NEW_JERSEY("New Jersey"),
    NEW_YORK("New York"),
    OHIO("Ohio"),
    TEXAS("Texas"),
    PENNSYLVANIA("Pennsylvania"),
    WASHINGTON("Washington");

    public final String name;

    Cities(String name) {
        this.name = name;
    }
}
