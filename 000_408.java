class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
                continue;
            }

            if (!Character.isDigit(c2) || c2 == '0') {
                return false;
            }

            int num = 0;
            while (Character.isDigit(c2)) {
                num *= 10;
                num += c2 - '0';
                j++;
                if (j == abbr.length()) {
                    break;
                }
                c2 = abbr.charAt(j);
            }
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
