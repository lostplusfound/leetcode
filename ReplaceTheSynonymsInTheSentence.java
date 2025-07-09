import java.util.*;

public class ReplaceTheSynonymsInTheSentence {
    /**
     * @param synonyms: The list of synonyms.
     * @param text:     Source text.
     * @return: Sentences that have been replaced with synonyms.
     */
    public String[] replaceSynonyms(String[][] synonyms, String text) {
        // --- write your code here ---
        Map<String, Integer> wordToId = new HashMap<>();
        Map<Integer, String> idToWord = new HashMap<>();
        int count = 0;
        for (int i = 0; i < synonyms.length; i++) {
            for (int j = 0; j < synonyms[i].length; j++) {
                if (!wordToId.containsKey(synonyms[i][j])) {
                    wordToId.put(synonyms[i][j], count);
                    idToWord.put(count++, synonyms[i][j]);
                }
            }
        }
        int[] union = new int[count];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        for (String[] arr : synonyms) {
            connect(wordToId.get(arr[0]), wordToId.get(arr[1]), union);
        }
        String[] words = text.split(" ");
        Set<Integer> indices = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (wordToId.containsKey(words[i])) {
                indices.add(i);
            }
        }
        Map<Integer, List<String>> variations = new HashMap<>();
        for (int i : indices) {
            List<String> poss = new ArrayList<>();
            int id = wordToId.get(words[i]);
            for (int j = 0; j < union.length; j++) {
                if (union[j] == union[id]) {
                    poss.add(idToWord.get(j));
                }
            }
            variations.put(i, poss);
        }
        Set<String> combinations = new HashSet<>();
        combinations.add("");
        for (int i = 0; i < words.length; i++) {
            Set<String> next = new HashSet<>();
            for (String c : combinations) {
                if (!indices.contains(i)) {
                    next.add(c + " " + words[i]);
                } else {
                    for (String v : variations.get(i)) {
                        next.add(c + " " + v);
                    }
                }
            }
            combinations = next;
        }
        String[] ans = new String[combinations.size()];
        int i = 0;
        for(String c : combinations) {
            ans[i++] = c.trim();
        }
        Arrays.sort(ans);
        System.out.println(ans);
        return ans;
    }

    private void connect(int p, int q, int[] union) {
        int pId = union[p];
        int qId = union[q];
        for (int i = 0; i < union.length; i++) {
            if (union[i] == qId) {
                union[i] = pId;
            }
        }
    }

    private boolean isConnected(int p, int q, int[] union) {
        return union[p] == union[q];
    }
}
