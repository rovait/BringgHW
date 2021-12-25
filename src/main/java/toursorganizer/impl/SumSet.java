package toursorganizer.impl;

import toursorganizer.impl.Group;
import toursorganizer.impl.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumSet {
    public static List<Group> sumUpRecursive(List<Group> groups, Site site, List<Group> partialGroups, int lowestOccupancy) {
        int sum = 0;
        List<Group> readyGroups = new ArrayList<>();
        boolean found = false;
        for (Group g: partialGroups) {
            sum += g.getPeopleNumber();
            readyGroups.add(g);
        }
        if (isGoodOccupancy(sum, site, lowestOccupancy)) {
            return getReadyGroupsIfValid(readyGroups, true);
        }
        for(int i = 0;i < groups.size() && !found;i++) {
            List<Group> remaining = new ArrayList();
            Group g = groups.get(i);
            for (int j=i+1; j<groups.size();j++) {
                remaining.add(groups.get(j));
            }
            List<Group> partial_rec = new ArrayList(partialGroups);
            partial_rec.add(g);
            readyGroups = sumUpRecursive(remaining, site, partial_rec, lowestOccupancy);
            int tempSum = readyGroups.stream().collect(Collectors.summingInt(Group::getPeopleNumber));
            found = isGoodOccupancy(tempSum, site, lowestOccupancy) || i == (groups.size()-1) ? true : false;
        }
        return getReadyGroupsIfValid(readyGroups, found);
    }

    public static boolean isGoodOccupancy(int number, Site site, int lowestOccupancy){
        int currentOccupancy = number*100/site.getOccupancy();
        return currentOccupancy < lowestOccupancy || currentOccupancy > 100 ? false :true;
    }

    public static List<Group> getReadyGroupsIfValid(List<Group> readyGroups, boolean found){
        return found && readyGroups.size() > 1 ? readyGroups : new ArrayList<>();
    }
}
