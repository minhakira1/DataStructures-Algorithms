class Solution {
 public int maxProfit(int[] prices) {
        int smallerValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (smallerValue > price) {
                smallerValue = price;
                continue;
            }
            if (price - smallerValue > maxProfit)
                maxProfit = price - smallerValue;
        }
        return maxProfit;
    }
}
