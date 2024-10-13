class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        for (int currRow = 0; currRow < numRows; currRow++) {
            int i = currRow;
            boolean diag = false;
            while (i < s.length()) {
                result.append(s.charAt(i));
                diag = !diag;
                if (currRow != 0 && currRow != numRows - 1) {
                    if (diag) {
                        i += numRows * 2 - 2 - 2 * currRow;
                    } else {
                        i += 2 * currRow;
                    }
                } else {
                    i += numRows * 2 - 2;
                }
            }
        }
        return result.toString();
    }
}
