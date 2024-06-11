import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    private static final int N = 1;

    public List<List<String>> groupAnagrams(String[] strs) {
        if (N == 0) return getSol0(strs);
        return getSol1(strs);
    }

    public List<List<String>> getSol0(String[] strs) {
        List<Integer> cMapDefault = Collections.nCopies(26, 0);

        HashMap<List<Integer>, ArrayList<String>> anagMap = new HashMap<>();
        for (String str : strs) {
            ArrayList<Integer> cMap = new ArrayList<>(cMapDefault);
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                cMap.set(c, cMap.get(c) + 1);
            }
            if (!anagMap.containsKey(cMap)) {
                anagMap.put(cMap, new ArrayList<>());
            }
            anagMap.get(cMap).add(str);
        }
        return new ArrayList<>(anagMap.values());
    }

    public List<List<String>> getSol1(String[] strs) {
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
