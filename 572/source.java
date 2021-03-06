class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int minimumPrice = prices[0];

        for (int price : prices) {
            if (price <= minimumPrice) {
                minimumPrice = price;
            } else {
                int currentProfit = price - minimumPrice;
                if (currentProfit > maximumProfit) {
                    maximumProfit = currentProfit;
                }
            }
        }

        return maximumProfit;
    }
}