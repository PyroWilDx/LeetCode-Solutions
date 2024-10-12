class Solution {
    public int romanToInt(String s) {
        int[] valMap = new int[256];
        valMap['I'] = 1;
        valMap['V'] = 5;
        valMap['X'] = 10;
        valMap['L'] = 50;
        valMap['C'] = 100;
        valMap['D'] = 500;
        valMap['M'] = 1000;

        int result = valMap[s.charAt(0)];
        char lastChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            result += valMap[currChar];
            if (lastChar == 'C' && (currChar == 'M' || currChar == 'D')) {
                result -= 200;
            }
            if (lastChar == 'X' && (currChar == 'C' || currChar == 'L')) {
                result -= 20;
            }
            if (lastChar == 'I' && (currChar == 'X' || currChar == 'V')) {
                result -= 2;
            }
            lastChar = currChar;
        }
        return result;
    }
}
