import java.util.*;

public class SortFeaturesByPopularity {
    /**
     * @param features: A string array
     * @param responses: A string array
     * @return: Array of sorted features
     */
    public String[] sortFeatures(String[] features, String[] responses) {
        // write your code here
        Map<String, Integer> featureMap = new HashMap<>();
        for(String f : features) {
            featureMap.put(f, 0);
        }
        for(String r : responses) {
            Set<String> set = new HashSet<>();
            String[] words = r.split(" ");
            for(String w : words) {
                if(featureMap.containsKey(w)) {
                    set.add(w);
                }
            }
            for(String f : set) {
                featureMap.put(f, featureMap.get(f) + 1);
            }
        }
        Arrays.sort(features, Comparator.comparing(o -> featureMap.get(o)).reversed());
        return features;
    }
}
