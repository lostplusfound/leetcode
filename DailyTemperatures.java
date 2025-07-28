import java.util.*;

public class DailyTemperatures {
    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer
     *          temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // Write your code here
        int[] daysUntilWarmer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            int days = 0;
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temp) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                days = stack.peek() - i;
            }
            stack.push(i);
            daysUntilWarmer[i] = days;
        }
        return daysUntilWarmer;
    }
}
