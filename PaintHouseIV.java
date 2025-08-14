class PaintHouseIV {
    private long[][][] cache;
    public long minCost(int n, int[][] cost) {
        cache = new long[n/2][3][3];
        long[] houses = new long[n];
        return dfs(0, 0, houses,cost );
    }

    private long dfs(int d, long c, long[] houses, int[][] cost) {
        if(d >= houses.length/2) {
            return c;
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
                c += lCosts[lColor] + rCosts[rColor];
                cache[d][lColor][rColor] = dfs(d + 1, c, houses, cost);
                minCost = Math.min(minCost, cache[d][lColor][rColor]);
                c -= lCosts[lColor] + rCosts[rColor];
            }
        }
        return minCost;
    }
}