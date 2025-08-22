public class MaxNumVowels {
    public int maxVowels(String s, int k) {
        int maxNumVowels = 0;
        int numVowels = 0;
        for(int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVowels++;
            }
        }
        maxNumVowels = numVowels;
        for(int i = 1; i <= s.length() - k; i++) {
            char c = s.charAt(i - 1);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVowels--;
            }
            c = s.charAt(i + k - 1);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVowels++;
            }
            maxNumVowels = Math.max(maxNumVowels, numVowels);
        }
        return maxNumVowels;
    }
}
