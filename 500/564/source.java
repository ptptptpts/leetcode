class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        boolean isFindMin = true;
        int curMax = prices[0];
        int curMin = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (isFindMin) {
                if (prices[i] <= curMin) {
                    curMin = prices[i];
                } else {
                    isFindMin = false;
                    curMax = prices[i];
                }
            } else {
                if (prices[i] >= curMax) {
                    curMax = prices[i];
                } else {
                    maxProfit += curMax - curMin;
                    isFindMin = true;
                    curMin = prices[i];
                }
            }            
        }

        if (!isFindMin) {
            maxProfit += prices[prices.length - 1] - curMin;
        }

        return maxProfit;
    }
}