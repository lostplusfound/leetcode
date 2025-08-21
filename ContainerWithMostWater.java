public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int L = 0;
        int R = height.length - 1;
        while (L < R) {
            maxArea = Math.max(maxArea, Math.min(height[L], height[R]) * (R - L));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
