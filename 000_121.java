class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int result = 0;

        int buyI = 0;
        int sellI = 0;
        while (sellI < prices.length) {
            int profit = prices[sellI] - prices[buyI];
            if (profit < 0)
                buyI = sellI;
            else if (profit > result)
                result = profit;
            sellI++;
        }

        return result;
    }
}
