class Solution {
    public String oddString(String[] words) {
        int[] diffIntArray0 = new int[words[0].length() - 1];
        for (int i = 1; i < words[0].length(); i++) {
            diffIntArray0[i - 1] = words[0].charAt(i) - words[0].charAt(i - 1);
        }

        int currIndex = 0;
        boolean diffAtIndex1 = false;
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                int diffInt = word.charAt(i) - word.charAt(i - 1);
                if (diffInt != diffIntArray0[i - 1]) {
                    if (currIndex == 1) {
                        diffAtIndex1 = true;
                    } else if (currIndex == 2 && diffAtIndex1) {
                        return words[0];
                    } else {
                        return word;
                    }
                }
            }
            if (currIndex == 2 && diffAtIndex1) {
                return words[1];
            }
            currIndex++;
        }

        throw new IllegalArgumentException("No Solution.");
    }
}
