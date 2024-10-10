class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] srcCharCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            srcCharCount[chars.charAt(i) - 'a']++;
        }

        int result = 0;

        for (String word : words) {
            int[] charCount = srcCharCount.clone();
            boolean validWord = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (charCount[c] == 0) {
                    validWord = false;
                    break;
                }
                charCount[c]--;
            }
            if (validWord) {
                result += word.length();
            }
        }
        return result;
    }
}
