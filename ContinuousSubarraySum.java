public class ContinuousSubarraySum {
    public int getSum(int[] nums) {
        // write your code here
        long sum = 0;
        for(int n : nums) {
            sum += n;
        }
        int L = 0;
        while(L < nums.length) {
            int R = L + 1;
            int value = nums[L];
            while(R < nums.length) {
                if(nums[R] - nums[R - 1] != 1 && nums[R] - nums[R - 1] != -1) {
                    break;
                }
                value += nums[R];
                sum += value;
                R++;
            }
            L++;
        }
        return (int) (sum % (1000000000 + 7));
    }
}