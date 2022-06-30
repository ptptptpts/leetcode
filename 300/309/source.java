class Solution {
    public int maxProfit(int[] prices) {
        int[] buys = new int[] {0, prices[0] * -1};
        int[] sells = new int[] {0, 0, 0};

        for (int i = 1; i < prices.length; i++) {
            sells[0] = Math.max(sells[1], buys[1] + prices[i]);
            buys[0] = Math.max(buys[1], sells[2] - prices[i]);

            sells[2] = sells[1];
            sells[1] = sells[0];
            buys[1] = buys[0];
        }

        return sells[0];
    }
}
