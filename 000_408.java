class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < abbr.length()) {
            if (j >= word.length()) {
                return false;
            }
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0') {
                    return false;
                }
                int num = 0;
                while (Character.isDigit(c)) {
                    num *= 10;
                    num += c - '0';
                    i++;
                    if (i >= abbr.length()) {
                        break;
                    }
                    c = abbr.charAt(i);
                }
                j += num;
            } else {
                if (c != word.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return j == word.length();
    }
}
