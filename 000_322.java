import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinAmounts = new int[amount + 1];
        Arrays.fill(coinAmounts, Integer.MAX_VALUE);
        coinAmounts[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coinAmountLeft = i - coins[j];
                if (coinAmountLeft < 0) {
                    continue;
                }
                if (coinAmounts[coinAmountLeft] == Integer.MAX_VALUE) {
                    continue;
                }
                coinAmounts[i] = Math.min(coinAmounts[i], 1 + coinAmounts[coinAmountLeft]);
            }
        }
        if (coinAmounts[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return coinAmounts[amount];
    }
}
