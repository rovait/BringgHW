package toursorganizer.impl;

import toursorganizer.enums.Countries;
import toursorganizer.enums.SiteTypes;

public class Group {

    int peopleNumber;
    Countries originCountry;
    SiteTypes destinationSite;


    public Group() {
    }

    public Group(int peopleNumber, Countries originCountry, SiteTypes destinationSite) {
        this.peopleNumber = peopleNumber;
        this.originCountry = originCountry;
        this.destinationSite = destinationSite;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Countries getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(Countries originCountry) {
        this.originCountry = originCountry;
    }

    public SiteTypes getDestinationSite() {
        return destinationSite;
    }

    public void setDestinationSite(SiteTypes destinationSite) {
        this.destinationSite = destinationSite;
    }
}
