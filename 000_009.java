class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int num = x;
        int reverse = 0;
        while (num > 0) {
            reverse *= 10;
            reverse += num % 10;
            num /= 10;
        }

        return reverse == x;
    }
}
