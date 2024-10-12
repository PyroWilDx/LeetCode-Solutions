class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[] {
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1 };
        String[] valToRom = new String[] {
                "M",
                "CM",
                "D",
                "CD",
                "C",
                "XC",
                "L",
                "XL",
                "X",
                "IX",
                "V",
                "IV",
                "I"
        };

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (vals[i] > num) {
                i++;
                continue;
            }
            num -= vals[i];
            result.append(valToRom[i]);
        }
        return result.toString();
    }
}
