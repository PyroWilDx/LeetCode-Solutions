class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        final int N = piles.length;

        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            if (piles[i] > maxValue)
                maxValue = piles[i];
        }

        int result = -1;

        int k1 = 1;
        int k2 = maxValue;
        while (k1 != k2) {
            int k = (k1 + k2) / 2;
            int canEat = canEatAllBananas(piles, h, k);
            if (canEat == 0) {
                result = k;
                k2 = k;
                continue;
            }
            if (canEat > 0)
                k2 = k;
            else
                k1 = k + 1;
        }

        if (result == -1)
            result = k1;

        return result;
    }

    public int canEatAllBananas(int[] piles, int h, int k) {
        for (int i = 0; i < piles.length; i++) {
            h -= piles[i] / k;
            if (piles[i] % k != 0)
                h--;
            if (h == 0 && i != piles.length - 1)
                return -1;
            if (h < 0)
                return -1;
        }
        if (h == 0)
            return 0;
        return 1;
    }
}
