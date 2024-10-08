import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            n = calcSquaredDigits(n);
        }
        return true;
    }

    public int calcSquaredDigits(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result += digit * digit;
            num /= 10;
        }
        return result;
    }
}
