class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                double sq = myPow(1 / x, -(Integer.MIN_VALUE / 2));
                return sq * sq;
            }
            return myPow(1 / x, -n);
        }

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            double sq = myPow(x, n / 2);
            return sq * sq;
        }

        return x * myPow(x, n - 1);
    }
}
