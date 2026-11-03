class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] maxSuffArray = new int[length];
        maxSuffArray[length - 1] = prices[length - 1];
        for (int i = length - 2; i >= 0; i --) {
            maxSuffArray[i] = Math.max(prices[i], maxSuffArray[i + 1]);
        }
        int profit = 0;
        for (int i = 0; i < length - 1; i += 1) {
            profit = Math.max(profit, maxSuffArray[i + 1] - prices[i]);
        }
        return profit;
    }
}
