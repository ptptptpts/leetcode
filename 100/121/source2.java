class Solution {
    public int maxProfit(int[] prices) {
        // Input: A price of stock on each day
        // Output: The maximum profit can get from the given prices

        // Is there any limit to buy and sell a stock? You can buy and sell a stock only once

        // What is a length of prices? 1 <= n <= 10^5
        // What is a range of prices? 0 <= n <= 10^4

        // To sell a stock, we should buy a stock previously.
        // So, it means on each day, we can sell a stock by the lowest price on the previous days.
        // And the maximum profit will be the maximum one in there.

        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            maximumProfit = Math.max(maximumProfit, price - lowestPrice);
        }

        return maximumProfit;
    }
}