public class ContinuousSubarraySum {
    /**
     * @param nums: An integer array
     * @return: Sum of all good subarray elements
     */
    public int getSum(int[] nums) {
        // write your code here
        long sum = 0;
        for(int n : nums) {
            sum += n;
        }
        List<List<Integer>> goodSubarrays = getGoodSubarrays(nums);
        for(List<Integer> subarray : goodSubarrays) {
            for(int i = 0; i < subarray.size(); i++) {
                long numOccurences =  i * (subarray.size() - i - 1) + i + subarray.size() - i - 1;
                sum += (subarray.get(i) * numOccurences);
            }
        }
        return (int) (sum % (1000000000 + 7));
    }
    public List<List<Integer>> getGoodSubarrays(int[] nums) {
        List<List<Integer>> goodSubarrays = new ArrayList<>();
        int L = 0;
        int R = 0;
        while(L < nums.length) {
            List<Integer> goodArray = new ArrayList<>();
            while(R < nums.length) {
                if(R != L && nums[R] - nums[R - 1] != 1) {
                    break;
                }
                goodArray.add(nums[R++]);
            }
            if(goodArray.size() > 1) {
                goodSubarrays.add(goodArray);
            }
            L = R;
        }
        L = 0;
        R = 0;
        while(L < nums.length) {
            List<Integer> goodArray = new ArrayList<>();
            while(R < nums.length) {
                if(R != L && nums[R] - nums[R - 1] != -1) {
                    break;
                }
                goodArray.add(nums[R++]);
            }
            if(goodArray.size() > 1) {
                goodSubarrays.add(goodArray);
            }
            L = R;
        }
        return goodSubarrays;
    }
}