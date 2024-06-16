import java.util.HashSet;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int maxCount = 0;
        int nOfCharAtMaxCount = 0;

        HashSet<Character> tChars = new HashSet<>();
        int[] charCount = new int[Math.max('z', 'Z') + 1];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            tChars.add(c);

            charCount[c]++;
            if (charCount[c] > maxCount) {
                maxCount = charCount[c];
                nOfCharAtMaxCount = 1;
            } else if (charCount[c] == maxCount) nOfCharAtMaxCount++;
        }

        int bestI = 0;
        int bestJ = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int maxI = s.length() - t.length() + 1;
        while (left < maxI) {
            boolean isMinWinSubStr = maxCount <= 0;
            if (isMinWinSubStr || right == s.length()) {
                if (right == s.length() && !isMinWinSubStr) break;
                
                if (isMinWinSubStr && (right - left < bestJ - bestI)) {
                    bestI = left;
                    bestJ = right;
                }
                char cLeft = s.charAt(left);
                if (tChars.contains(cLeft)) {
                    charCount[cLeft]++;
                    if (charCount[cLeft] > maxCount) {
                        maxCount = charCount[cLeft];
                        nOfCharAtMaxCount = 1;
                    } else if (charCount[cLeft] == maxCount) nOfCharAtMaxCount++;
                }
                left++;
            } else {
                char cRight = s.charAt(right);
                if (tChars.contains(cRight)) {
                    charCount[cRight]--;
                    if (charCount[cRight] + 1 == maxCount) {
                        if (nOfCharAtMaxCount == 1) {
                            maxCount = charCount[cRight];
                            nOfCharAtMaxCount = getNOfCharAtCount(charCount, maxCount);
                        } else {
                            nOfCharAtMaxCount--;
                        }
                    }
                }

                right++;    
            }
        }

        if (bestI == 0 && bestJ == Integer.MAX_VALUE) return "";
        return s.substring(bestI, bestJ);
    }

    public int getNOfCharAtCount(int[] charCount, int count) {
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (charCount[c] == count) result++;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (charCount[c] == count) result++;
        }
        return result;
    }
}
