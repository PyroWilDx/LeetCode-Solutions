class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map[c] == 0)
                return false;
            map[c]--;
            if (map[c] < 0)
                return false;
        }

        return true;
    }
}
