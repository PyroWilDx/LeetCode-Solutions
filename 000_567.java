import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            if (!charCount.containsKey(c1)) {
                charCount.put(c1, 1);
            } else {
                int newCount = charCount.get(c1) + 1;
                if (newCount == 0)
                    charCount.remove(c1);
                else
                    charCount.put(c1, newCount);
            }

            char c2 = s2.charAt(i);
            if (!charCount.containsKey(c2)) {
                charCount.put(c2, -1);
            } else {
                int newCount = charCount.get(c2) - 1;
                if (newCount == 0)
                    charCount.remove(c2);
                else
                    charCount.put(c2, newCount);
            }
        }

        if (charCount.isEmpty())
            return true;

        int left = 1;
        int right = s1.length();
        while (right < s2.length()) {
            char c1 = s2.charAt(left - 1);
            if (!charCount.containsKey(c1)) {
                charCount.put(c1, 1);
            } else {
                int newCount = charCount.get(c1) + 1;
                if (newCount == 0)
                    charCount.remove(c1);
                else
                    charCount.put(c1, newCount);
            }

            char c2 = s2.charAt(right);
            if (!charCount.containsKey(c2)) {
                charCount.put(c2, -1);
            } else {
                int newCount = charCount.get(c2) - 1;
                if (newCount == 0)
                    charCount.remove(c2);
                else
                    charCount.put(c2, newCount);
            }

            if (charCount.isEmpty())
                return true;

            left++;
            right++;
        }

        return false;
    }
}
