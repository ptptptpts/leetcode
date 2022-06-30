class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] numOfCoins = new int[amount + 1];
        numOfCoins[0] = 0;

        for (int price = 1; price <= amount; price++) {
            int cases = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (price > coin) {
                    int previousCase = numOfCoins[price - coin];
                    if (previousCase > 0) {
                        cases = Math.min(cases, previousCase + 1);
                    }
                } else if (price == coin) {
                    cases = 1;
                }
            }
            if (cases == Integer.MAX_VALUE) {
                cases = 0;
            }
            numOfCoins[price] = cases;
        }

        if (numOfCoins[amount] == 0) {
            return -1;
        } else {
            return numOfCoins[amount];
        }
    }
}
