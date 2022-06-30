class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int buy = -1 * prices[0];

        // All three solutions are possible
        // Assume we can move to buy[i] from sell[i-1] because sell and buy a stock at the same day is meaningless.
        for (int price : prices) {
            int prevSell = sell;
            sell = Math.max(sell, buy + price - fee);
            buy = Math.max(buy, prevSell - price);
        }

        // Assume we can move to buy[i] from sell[i] because sell[i] don't have a stock.
        // for (int price : prices) {
        //     sell = Math.max(sell, buy + price - fee);
        //     buy = Math.max(buy, sell - price);
        // }

        // Assume we can move to sell[i] from buy[i] because buy[i] have a stock
        // for (int price : prices) {
        //     buy = Math.max(buy, sell - price);
        //     sell = Math.max(sell, buy + price - fee);
        // }

        return sell;
    }
}
