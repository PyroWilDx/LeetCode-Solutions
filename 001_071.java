class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int pgcd = pgcd(str1.length(), str2.length());
        String x = str1.substring(0, pgcd);
        if (!isDivisor(str1, x) || !isDivisor(str2, x)) {
            return "";
        }
        return x;
    }

    public int pgcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return pgcd(b, a % b);
    }

    public boolean isDivisor(String str, String x) {
        for (int i = 0; i < str.length(); i += x.length()) {
            if (!str.substring(i, i + x.length()).equals(x)) {
                return false;
            }
        }
        return true;
    }
}
