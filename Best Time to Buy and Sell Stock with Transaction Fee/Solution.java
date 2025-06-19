import java.util.*;

public class Solution {
    /**
     * @param prices: a list of integers
     * @param fee:    a integer
     * @return: return a integer
     */
    private TreeMap<Integer, List<int[]>> intervalsMap = new TreeMap<>();

    public int maxProfit(int[] prices, int fee) {
        // write your code here
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (getProfit(prices, i, j, fee) > 0) {
                    intervals.add(new int[] { i, j });
                }
            }
        }
        for (int[] i : intervals) {
            List<int[]> l = intervalsMap.getOrDefault(i[0], new ArrayList<>());
            l.add(i);
            intervalsMap.put(i[0], l);
        }
        for (int[] i : intervals) {
            System.out.println(Arrays.toString(i));
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.size(); i++) {
            int[] initialInterval = intervals.get(i);
            int initialProfit = getProfit(prices, initialInterval[0], initialInterval[1], fee);
            maxProfit = Math.max(maxProfit, dfs(prices, intervals, initialInterval, initialProfit, fee));
        }
        return maxProfit;
    }

    private int dfs(int[] prices, List<int[]> intervals, int[] currentInterval, int profit, int fee) {
        int maxNextProfit = 0;
        for (List<int[]> nextIntervals : intervalsMap.tailMap(currentInterval[1], false).values()) {
            for (int[] nextInterval : nextIntervals) {
                int nextProfit = getProfit(prices, nextInterval[0], nextInterval[1], fee);
                if (nextInterval[0] > currentInterval[1] && nextProfit > 0) {
                    maxNextProfit = Math.max(maxNextProfit, dfs(prices, intervals, nextInterval, nextProfit, fee));
                }
            }
        }
        return profit + maxNextProfit;
    }

    private int getProfit(int[] prices, int buyDay, int sellDay, int fee) {
        return prices[sellDay] - prices[buyDay] - fee;
    }
}