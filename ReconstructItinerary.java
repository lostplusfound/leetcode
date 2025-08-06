import java.util.*;

public class ReconstructItinerary {
    /**
     * @param tickets: the list of the airline tickets
     * @return: the reconstructed itinerary
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // Write your code here
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(t.size() - 1);
            List<String> l = map.getOrDefault(from, new ArrayList<>());
            l.add(to);
            map.put(from, l);
        }
        for(List<String> l : map.values()) {
            Collections.sort(l);
        }
        List<String> itinerary = new ArrayList<>();
        itinerary.add("JFK");
        dfs(map, itinerary, "JFK");
        return itinerary;
    }

    private boolean dfs(Map<String, List<String>> map, List<String> itinerary, String current) {
        if(map.isEmpty()) {
            return true;
        }
        List<String> dests = map.getOrDefault(current, new ArrayList<>());
        for(int i = 0; i < dests.size(); i++) {
            String d = dests.remove(i);
            itinerary.add(d);
            if(dests.isEmpty()) {
                map.remove(current);
            }
            if(dfs(map, itinerary, d)) {
                return true;
            } else {
                dests.add(i, d);
                if(!map.containsKey(current)) {
                    map.put(current, dests);
                }
                itinerary.remove(itinerary.size() - 1);
            }
        }
        return false;
    }
}