import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        
        int result = 1;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int i = 0;
        int first = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c)) {
                int length = charIndexMap.size();
                if (length > result) result = length;
                
                int nextFirst = charIndexMap.get(c) + 1;
                for (int j = first; j < nextFirst; j++) charIndexMap.remove(s.charAt(j));
                first = nextFirst;
            }
            charIndexMap.put(c, i);
            i++;
        }

        return Math.max(result, charIndexMap.size());
    }
}
