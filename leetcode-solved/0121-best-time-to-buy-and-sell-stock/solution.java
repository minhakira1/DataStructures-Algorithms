class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int idx = 0; idx < prices.length; idx++) {
            if (minPrice > prices[idx]) {
                minPrice = prices[idx];
            }
            max = Math.max(prices[idx] - minPrice, max);
        }
        return max;
    }
}
