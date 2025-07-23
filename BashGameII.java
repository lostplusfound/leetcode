import java.util.*;

public class BashGameII {
    /**
     * @param rocks: The number of stones in each pile.
     * @return: Whether you can win the game.
     */

    public boolean canWinBash(int[] rocks) {
        // --- write your code here ---
        return dfs(rocks, new HashMap<>());
    }

    private boolean dfs(int[] rocks, Map<String, Boolean> memoMap) {
        String rocksString = "";
        for(int r : rocks) {
            if(r > 0) {
                rocksString += r;
            }
        }
        if(memoMap.containsKey(rocksString)) {
            return memoMap.get(rocksString);
        }
        for(int i = 0; i < rocks.length; i++) {
            for(int remove = 1; remove <= rocks[i]; remove++) {
                rocks[i] -= remove;
                boolean canWinNext = dfs(rocks, memoMap);
                rocks[i] += remove;
                if(!canWinNext) {
                    memoMap.put(rocksString, true);
                    return true;
                } 
            }
        }
        memoMap.put(rocksString, false);
        return false;
    }
}