public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            int numOnes = 0;
            for(int j = 0; j < 32; j++) {
                int mask = 1 << j;
                if((i & mask) > 0) {
                    numOnes++;
                }
            }
            ans[i] = numOnes;
        }
        return ans;
    }
}
