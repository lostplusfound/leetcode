public class BestTimeToBuyAndSellStock {
    private int[] notHolding;
    private int[] isHolding;

    public int maxProfit(int[] prices, int fee) {
        notHolding = new int[prices.length];
        isHolding = new int[prices.length];
        return dfs(0, false, prices, fee);
    }

    private int dfs(int index, boolean holding, int[] prices, int fee) {
        if(index >= prices.length) {
            return 0;
        }
        if (holding) {
            if(isHolding[index] > 0) {
                return isHolding[index];
            }
            int holdProfit =  dfs(index + 1, true, prices, fee);
            int sellProfit = prices[index] - fee + dfs(index + 1, false, prices, fee);
            isHolding[index] = Math.max(holdProfit, sellProfit);
            return isHolding[index];
        } else {
            if(notHolding[index] > 0) {
                return notHolding[index];
            }
            int holdProfit = dfs(index + 1, false, prices, fee);
            int buyProfit = -prices[index] + dfs(index + 1, true, prices, fee);
            notHolding[index] = Math.max(holdProfit, buyProfit);
            return notHolding[index];
        }
    }
}
