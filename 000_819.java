import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        String[] words = paragraph.split(" +");
        Map<String, Integer> wordsCounts = new HashMap<>();
        for (String word : words) {
            if (bannedSet.contains(word)) {
                continue;
            }

            wordsCounts.computeIfAbsent(word, v -> 0);
            wordsCounts.put(word, wordsCounts.get(word) + 1);
        }

        String result = "";
        int currMaxCount = 0;
        for (Map.Entry<String, Integer> entry : wordsCounts.entrySet()) {
            if (entry.getValue() > currMaxCount) {
                result = entry.getKey();
                currMaxCount = entry.getValue();
            }
        }
        return result;
    }
}
