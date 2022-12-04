package toursorganizer;

import toursorganizer.enums.SiteTypes;
import toursorganizer.impl.Group;
import toursorganizer.impl.Site;
import toursorganizer.impl.SumSet;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MFAHandler {

    LinkedList<Site> sites = new LinkedList<>();
    int LOWEST_OCCUPANCY = 90;
    public MFAHandler() {

    }

    public List<Site> getListOfSites(List<Group> groups){
        List<SiteTypes> siteTypesList =  groups.stream().map(Group::getDestinationSite).distinct().collect(Collectors.toList());
        List<Site> sitesToVisitList = new ArrayList<>();
        siteTypesList.stream().forEach(siteType -> {
            Optional<Site> foundSite = sites.stream()
                    .filter(site -> site.getSite().equals(siteType)).findFirst();
            if(foundSite.isPresent()) {
                sitesToVisitList.add(foundSite.get());
            }
        });
        return sitesToVisitList;
    }

    public List<Site> getSitesDealReady(LinkedList<Group> groups){
        List<Site> readySites = new ArrayList<>();
        List<Site> desiredSites = getListOfSites(groups);
        desiredSites.stream().forEach(site -> {
            List<Group> groupsBySite = groups.stream().filter(g -> g.getDestinationSite().equals(site.getSite())).collect(Collectors.toList());
            List<Group> readyGroups = SumSet.sumUpRecursive(groupsBySite, site, new ArrayList(), LOWEST_OCCUPANCY);
            if(!readyGroups.isEmpty()){
                readySites.add(site);
            }
        });

        return readySites;
    }

    private Site getSiteByName(SiteTypes siteName){
        return sites.stream().filter(s ->s.getSite().equals(siteName)).findAny().get();
    }


    public LinkedList<Site> getSites() {
        return sites;
    }

    public void findLargestGroupBySite(LinkedList<Group> groups){
        List<Site> desiredSites = getListOfSites(groups);
        desiredSites.stream().forEach(site ->{
            Optional<Group> largestGroup = groups.stream().max(Comparator.comparing(Group::getPeopleNumber));
            if(largestGroup.isPresent()){
                System.out.println("Largest group for " + site.getSite() + "site is from " + largestGroup.get().getOriginCountry());
            }
        });
    }

    public HashMap<String, List<Group>> getGroupsBySiteMap(LinkedList<Group> groups){
        HashMap<String, List<Group>> siteByGroup = new HashMap<>();
        List<Site> desiredSites = getListOfSites(groups);
        desiredSites.stream().forEach(site ->{
            List<Group> groupsBySite = groups.stream().filter(distinctByKey(g ->g.getOriginCountry())).collect(Collectors.toList());
            siteByGroup.put(site.getSite().getSiteName(), groupsBySite);
        });
        return siteByGroup;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        final Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }
}

