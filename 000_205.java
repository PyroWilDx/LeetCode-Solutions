class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sMap = new char[256];
        boolean[] mappedChars = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tChar) {
                if (sMap[sChar] == 0 && !mappedChars[tChar]) {
                    sMap[sChar] = tChar;
                    mappedChars[tChar] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
