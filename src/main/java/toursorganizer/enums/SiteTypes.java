package toursorganizer.enums;

public enum SiteTypes {


    MINI_ISRAEL("Mini Israel"),
    ROCK_CHURCH("the Rock Church"),
    GARDENS_ISLANDS("Gardens in the Islands"),
    OLD_JAFFA("Old Jaffa"),
    TEL_AVIV("White Tel Aviv"),
    WESTERN_WALL("the Western Wall");

    private String siteName;
    private SiteTypes(String siteName) { this.siteName = siteName; }
    public String getSiteName() {
        return siteName;
    }
}
