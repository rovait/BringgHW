package toursorganizer.impl;

import toursorganizer.enums.SiteTypes;

public class Site {
    private int occupancy;
    private SiteTypes site;

    public Site(int occupancy, SiteTypes site) {
        this.occupancy = occupancy;
        this.site = site;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public SiteTypes getSite() {
        return site;
    }

    public void setSite(SiteTypes site) {
        this.site = site;
    }
}
