class Solution {
    public int[] plusOne(int[] digits) {
        int rest = 1;
        int i = digits.length - 1;
        while (rest != 0 && i >= 0) {
            int digit = digits[i];
            if (digit != 9) {
                digit++;
                rest = 0;
            } else {
                digit = 0;
                rest = 1;
            }
            digits[i] = digit;
            i--;
        }

        if (rest == 0) {
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (i = 0; i < digits.length; i++) {
            newDigits[i + 1] = digits[i];
        }
        return newDigits;
    }
}
