import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            if (!anagMap.containsKey(sortedString)) {
                anagMap.put(sortedString, new ArrayList<>());
            }
            anagMap.get(sortedString).add(str);
        }
        return new ArrayList<>(anagMap.values());
    }
}
