import java.util.Arrays;

public class CountPairsInTwoArrays {
    /**
     * @param nums1: An integer array
     * @param nums2: An integer array
     * @return: Total number of qualified index pairs
     */
    public long countPairs(int[] nums1, int[] nums2) {
        // write your code here
        long numPairs = 0;
        int[] diff = new int[nums1.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < diff.length; i++) {
            int index = Arrays.binarySearch(diff, 0 - diff[i] + 1);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index <= i) {
                index = i + 1;
            } else {
                while (index > i + 1 && diff[index - 1] >= 0 - diff[i] + 1) {
                    index--;
                }
            }
            int numGreater = diff.length - index;
            if (numGreater > 0) {
                numPairs += numGreater;
            }
        }
        return numPairs;
    }
}