class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int i = 0;
        while (i < prices.length) {
            i = findLastDecreasingIndex(prices, i);
            if (i == prices.length) {
                break;
            }
            int buyPrice = prices[i];
            i = findLastIncreasingIndex(prices, i);
            if (i == prices.length) {
                break;
            }
            int sellPrice = prices[i];
            result += sellPrice - buyPrice;
        }
        return result;
    }

    public int findLastDecreasingIndex(int[] prices, int i) {
        i++;
        while (i < prices.length) {
            if (prices[i] > prices[i - 1]) {
                return i - 1;
            }
            i++;
        }
        return i;
    }

    public int findLastIncreasingIndex(int[] prices, int i) {
        i++;
        while (i < prices.length) {
            if (prices[i] < prices[i - 1]) {
                return i - 1;
            }
            i++;
        }
        if (prices[i - 1] >= prices[i - 2]) {
            return i - 1;
        }
        return i;
    }
}
