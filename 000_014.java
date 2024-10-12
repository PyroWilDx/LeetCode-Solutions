class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j < Math.min(strs[i].length(), longestPrefix.length()); j++) {
                if (longestPrefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return "";
            }
            if (j != longestPrefix.length()) {
                longestPrefix = longestPrefix.substring(0, j);
            }
        }
        return longestPrefix;
    }
}
