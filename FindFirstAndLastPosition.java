import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindFirstAndLastPosition {
    /**
     * @param nums:   the array of integers
     * @param target:
     * @return: the starting and ending position
     */
    public List<Integer> searchRange(List<Integer> nums, int target) {
        // Write your code here.
        int index = Collections.binarySearch(nums, target);
        if (index < 0) {
            return Arrays.asList(-1, -1);
        }
        int left = index;
        while (left - 1 >= 0 && nums.get(left - 1) == target) {
            left--;
        }
        int right = index;
        while (right + 1 < nums.size() && nums.get(right + 1) == target) {
            right++;
        }
        return Arrays.asList(left, right);
    }
}