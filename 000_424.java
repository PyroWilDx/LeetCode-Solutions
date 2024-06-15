class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;

        int result = 0;

        int[] letterFreq = new int[26];
        letterFreq[s.charAt(0) - 'A'] = 1;
        int maxFreq = 1;
        int left = 0;
        int right = 0;
        while (true) {
            int length = right - left + 1;
            if (length - maxFreq > k) {
                letterFreq[s.charAt(left) - 'A']--;
                left++;
            } else {
                if (length > result) result = length;
                right++;
                if (right == s.length()) break;
                int currChar = s.charAt(right) - 'A';
                letterFreq[currChar]++;
                if (letterFreq[currChar] > maxFreq) maxFreq = letterFreq[currChar];
            }
        }

        return result;
    }
}
