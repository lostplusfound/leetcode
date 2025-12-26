class Solution {
    public int bestClosingTime(String customers) {
        int[] yPrefix = new int[customers.length() + 1];
        int[] nPrefix = new int[customers.length() + 1];
        for(int i = 1; i < yPrefix.length; i++) {
            if(customers.charAt(i - 1) == 'Y') {
                yPrefix[i] = yPrefix[i - 1] + 1;
                nPrefix[i] = nPrefix[i - 1];
            } else {
                nPrefix[i] = nPrefix[i - 1] + 1;
                yPrefix[i] = yPrefix[i - 1];
            }
        }
        int minPenalty = nPrefix[customers.length() - 1];
        int minHour = customers.length();
        for(int close = 0; close < customers.length(); close++) {
            int penalty = nPrefix[close] + (yPrefix[customers.length()] - yPrefix[close]);
            if(penalty < minPenalty || penalty == minPenalty && close < minHour) {
                minPenalty = penalty;
                minHour = close;
            }
        }
        return minHour;
    }
}
