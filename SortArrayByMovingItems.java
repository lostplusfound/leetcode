import java.util.*;

public class SortArrayByMovingItems {
    /**
     * @param nums: An integer array
     * @return: Minimum number of operations required to sort nums
     */
    public int sortArray(int[] nums) {
        // write your code here
        return Math.min(evalFirst(nums), evalLast(nums));
    }

    private int evalFirst(int[] nums) {
        nums = nums.clone();
        Map<Integer, Integer> indexOf = new HashMap<>();
        Set<Integer> outOfPlace = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            indexOf.put(nums[i], i);
            if (nums[i] != 0 && nums[i] != i) {
                outOfPlace.add(nums[i]);
            }
        }
        int operations = 0;
        while (!outOfPlace.isEmpty()) {
            operations++;
            int indexOfZero = indexOf.get(0);
            if (indexOfZero == 0) {
                int element = 0;
                for (int e : outOfPlace) {
                    element = e;
                    break;
                }
                int index = indexOf.get(element);
                nums[0] = element;
                nums[index] = 0;
                indexOf.put(element, 0);
                indexOf.put(0, index);
            } else {
                int element = indexOfZero;
                int index = indexOf.get(element);
                nums[indexOfZero] = element;
                nums[index] = 0;
                outOfPlace.remove(element);
                indexOf.put(element, indexOfZero);
                indexOf.put(0, index);
            }
        }
        return operations;
    }

    private int evalLast(int[] nums) {
        nums = nums.clone();
        Map<Integer, Integer> indexOf = new HashMap<>();
        Set<Integer> outOfPlace = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            indexOf.put(nums[i], i);
            if (nums[i] != 0 && nums[i] != i + 1) {
                outOfPlace.add(nums[i]);
            }
        }
        int operations = 0;
        while (!outOfPlace.isEmpty()) {
            operations++;
            int indexOfZero = indexOf.get(0);
            if (indexOfZero == nums.length - 1) {
                int element = 0;
                for (int e : outOfPlace) {
                    element = e;
                    break;
                }
                int index = indexOf.get(element);
                nums[nums.length - 1] = element;
                nums[index] = 0;
                indexOf.put(element, nums.length - 1);
                indexOf.put(0, index);
            } else {
                int element = indexOfZero + 1;
                int index = indexOf.get(element);
                nums[indexOfZero] = element;
                nums[index] = 0;
                outOfPlace.remove(element);
                indexOf.put(element, indexOfZero);
                indexOf.put(0, index);
            }
        }
        return operations;
    }

}