import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import toursorganizer.MFAHandler;
import toursorganizer.enums.Countries;
import toursorganizer.enums.SiteTypes;
import toursorganizer.impl.Group;
import toursorganizer.impl.Site;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ToursOrganizerTests {

    MFAHandler mfaHandler = new MFAHandler();
    LinkedList<Group> groups = new LinkedList<>();

    @Test(priority=1)
    @DisplayName("Preconditions")
    public void setupPreconditions(){
        groups.add(new Group(9, Countries.ENGLAND, SiteTypes.MINI_ISRAEL));
        groups.add(new Group(13, Countries.FRANCE, SiteTypes.MINI_ISRAEL));
        groups.add(new Group(6, Countries.LITHUANIA, SiteTypes.MINI_ISRAEL));
        groups.add(new Group(20, Countries.USA, SiteTypes.MINI_ISRAEL));
        groups.add(new Group(3, Countries.POLAND, SiteTypes.MINI_ISRAEL));
        groups.add(new Group(1, Countries.UKRAINE, SiteTypes.MINI_ISRAEL));

        groups.add(new Group(9, Countries.ENGLAND, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(13, Countries.FRANCE, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(6, Countries.LITHUANIA, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(20, Countries.USA, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(3, Countries.POLAND, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(1, Countries.UKRAINE, SiteTypes.GARDENS_ISLANDS));
        groups.add(new Group(40, Countries.GEORGIA, SiteTypes.GARDENS_ISLANDS));

        groups.add(new Group(24, Countries.ENGLAND, SiteTypes.TEL_AVIV));
        groups.add(new Group(35, Countries.FRANCE, SiteTypes.TEL_AVIV));
        groups.add(new Group(40, Countries.LITHUANIA, SiteTypes.TEL_AVIV));
        groups.add(new Group(40, Countries.USA, SiteTypes.TEL_AVIV));
        groups.add(new Group(40, Countries.POLAND, SiteTypes.TEL_AVIV));
        groups.add(new Group(40, Countries.UKRAINE, SiteTypes.TEL_AVIV));
        groups.add(new Group(40, Countries.GEORGIA, SiteTypes.TEL_AVIV));

        mfaHandler.getSites().add(new Site(30, SiteTypes.GARDENS_ISLANDS));
        mfaHandler.getSites().add(new Site(35, SiteTypes.MINI_ISRAEL));
        mfaHandler.getSites().add(new Site(33, SiteTypes.OLD_JAFFA));
        mfaHandler.getSites().add(new Site(45, SiteTypes.ROCK_CHURCH));
        mfaHandler.getSites().add(new Site(25, SiteTypes.TEL_AVIV));
        mfaHandler.getSites().add(new Site(39, SiteTypes.WESTERN_WALL));
    }

    @Test(priority=2)
    @DisplayName("Sites to Visit")
    public void getSitesToVisit(){
        List<Site> sites = mfaHandler.getListOfSites(groups);
        sites.stream().forEach(s -> {
            System.out.println("site to visit: " + s.getSite().getSiteName());
        });
    }

    @Test(priority=3)
    @DisplayName("Deal Ready Sites")
    public void getDealReadySites()throws Exception{
        List<Site> sites = mfaHandler.getSitesDealReady(groups);
        sites.stream().forEach(s -> {
            System.out.println("ready to book site: " + s.getSite().getSiteName());
        });
        if (sites.isEmpty()){
            System.out.println("No ready to book sites found!\n");
        }
    }

    @Test(priority=4)
    @DisplayName("Sites to Visit")
    public void getLargestGroupBySite(){
        mfaHandler.findLargestGroupBySite(groups);
    }

    @Test(priority=5)
    @DisplayName("Build Map with site/groups as key/value")
    public void getGroupsBySiteMap(){
        HashMap<String, List<Group>> map = mfaHandler.getGroupsBySiteMap(groups);
        map.keySet().stream().forEach(key -> {
            System.out.println("\ngroups for site " + key + ":");
            map.get(key).stream().forEach(group -> {
                System.out.println("group from " + group.getOriginCountry());
            });
        });
    }
}
