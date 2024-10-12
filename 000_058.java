class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        int lastCharIndex = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        int lastWordFirstCharIndex = i + 1;
        return lastCharIndex - lastWordFirstCharIndex + 1;
    }
}
