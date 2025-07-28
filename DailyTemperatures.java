public class DailyTemperatures {
    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // Write your code here
        int[] daysUntilWarmer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            int numDays = 0;
            for(int days = 1; days < temperatures.length - i; days++) {
                if(temperatures[i + days] > temp) {
                    numDays = days;
                    break;
                }
            }
            daysUntilWarmer[i] = numDays;
        }
        return daysUntilWarmer;
    }
}

