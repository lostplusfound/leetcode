public class BashGameII {
    /**
     * @param rocks: The number of stones in each pile.
     * @return: Whether you can win the game.
     */
    public boolean canWinBash(int[] rocks) {
        // --- write your code here ---
        return dfs(rocks);
    }

    private boolean dfs(int[] rocks) {
        for(int i = 0; i < rocks.length; i++) {
            for(int remove = 1; remove <= rocks[i]; remove++) {
                rocks[i] -= remove;
                boolean canWinNext = dfs(rocks);
                rocks[i] += remove;
                if(!canWinNext) {
                    return true;
                } 
            }
        }
        return false;
    }
}