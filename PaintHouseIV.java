class PaintHouseIV {
    private long[][][] cache;
    public long minCost(int n, int[][] cost) {
        long[] houses = new long[n];
        cache = new long[n/2][3][3];
        return dfs(0, houses,cost );
    }

    private long dfs(int d, long[] houses, int[][] cost) {
        if(d >= houses.length/2) {
            return 0;
        }
        int L = houses.length/2 - 1 - d;
        int R = houses.length/2 + d;
        int[] lCosts = cost[L];
        int[] rCosts = cost[R];
        long minCost = Long.MAX_VALUE;
        for(int lColor = 0; lColor < lCosts.length; lColor++) {
            for(int rColor = 0; rColor < rCosts.length; rColor++) {
                if(lColor == rColor) {
                    continue;
                }
                houses[L] = lColor;
                houses[R] = rColor;
                if(houses[L + 1] == lColor || houses[R - 1] == rColor) {
                    continue;
                }
                long currentCost = lCosts[lColor] + rCosts[rColor];
                if(cache[d][lColor][rColor] != 0) {
                    minCost = Math.min(minCost, currentCost + Math.min(minCost, cache[d][lColor][rColor]));
                    continue;
                }
                cache[d][lColor][rColor] = dfs(d + 1, houses, cost);
                minCost = Math.min(minCost, currentCost + cache[d][lColor][rColor]);
            }
        }
        return minCost;
    }
}