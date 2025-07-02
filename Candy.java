import java.util.Arrays;

public class Candy {
    /**
     * @param ratings: Children's ratings
     * @return: the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // write your code here
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int numCandies = candies.length;
        while (!check(ratings, candies)) {
            for (int i = 0; i < candies.length; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i]++;
                    numCandies++;
                }
                if (i < candies.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i]++;
                    numCandies++;
                }
            }
        }
        return numCandies;
    }

    private boolean check(int[] ratings, int[] candies) {
        for (int i = 0; i < candies.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                return false;
            }
            if (i < candies.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
