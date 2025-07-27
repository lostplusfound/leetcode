public class NumberOfPeopleSeen {
    /**
     * @param heights: People's height
     * @return: The number of people that can be seen
     */
    public int[][] seePeople(int[][] heights) {
        // write your code here
        int[][] res = new int[heights.length][heights[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                int numSeen = 0;
                int minHeight = 0;
                for (int row = i + 1; row < res.length; row++) {
                    int h = heights[row][j];
                    if (h > minHeight) {
                        numSeen++;
                        minHeight = h;
                    }
                    if (h >= heights[i][j]) {
                        break;
                    }
                }
                minHeight = 0;
                for (int col = j + 1; col < res[i].length; col++) {
                    int h = heights[i][col];
                    if (h > minHeight) {
                        numSeen++;
                        minHeight = h;
                    }
                    if (h >= heights[i][j]) {
                        break;
                    }
                }
                res[i][j] = numSeen;
            }
        }
        return res;
    }
}
