import java.util.*;

public class Solution {
    /**
     * @param prices: a list of integers
     * @param fee: a integer
     * @return: return a integer
     */
    private int[] cache;
    public int maxProfit(int[] prices, int fee) {
        // write your code here
        List<int[]> intervals = new ArrayList<>();
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(getProfit(prices, i, j, fee) > 0) {
                    intervals.add(new int[] {i, j});
                }
            }
        }
        cache = new int[intervals.size()];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.size(); i++) {
            int[] initialInterval = intervals.get(i);
            int initialProfit = getProfit(prices, initialInterval[0], initialInterval[1], fee);
            maxProfit = Math.max(maxProfit, dfs(prices, intervals, i, initialProfit, fee));
        }
        return maxProfit;
    }

    private int dfs(int[] prices, List<int[]> intervals, int i, int profit, int fee) {
        if(cache[i] > 0) {
            return cache[i];
        }
        int maxNextProfit = 0;
        int[] currentInterval = intervals.get(i);
        for(int next = i + 1; next < intervals.size(); next++) {
            int[] nextInterval = intervals.get(next);
            int nextProfit = getProfit(prices, nextInterval[0], nextInterval[1], fee);
            if(nextInterval[0] > currentInterval[1] && nextProfit > 0) {
                maxNextProfit = Math.max(maxNextProfit, dfs(prices, intervals, next, nextProfit, fee));
            }
        }
        cache[i] = maxNextProfit;
        return profit + maxNextProfit;
    }

    private int getProfit(int[] prices, int buyDay, int sellDay, int fee) {
        return prices[sellDay] - prices[buyDay] - fee;
    }
}