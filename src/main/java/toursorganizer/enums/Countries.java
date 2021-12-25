package toursorganizer.enums;

public enum Countries {
    USA("USA"),
    GEORGIA("Georgia"),
    LITHUANIA("Lithuania"),
    FRANCE("France"),
    UKRAINE("Ukraine"),
    POLAND("Poland"),
    ENGLAND("England");

    private String country;
    private Countries(String country) { this.country = country; }
    public String getCountry() {
        return country;
    }
}
