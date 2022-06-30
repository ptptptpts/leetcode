class Solution {
    public int coinChange(int[] coins, int amount) {
        // Input: integer array represents a price of coin, and integer amount that represents of a total amount of money
        // Output: the fewest number of coins that you need to make the amount. If we could not make the amount, return -1

        // Whats a size of the coins? 1 <= n <= 12
        // Whats a range of the amount? 0 <= amount <= 10^4
        // Whats a range of each coin? 1 <= n <= 2^31 - 1

        // Do I need to use at least one coin for making the amount? no

        // If we know the fewest number of coins until `n`, we can find the fewest number of coins
        // in `n` by trying to add each coin from the previous history.
        // For example, if we had '1, 2, 3' as a coin and want to find the fewest number of coins in
        // `5`, the fewest number of coin in `5` is adding 1 from the minimum value in f[4], f[3],
        // f[2].
        // Also, if a coin is larger than `n`, we can't use it for finding the fewest number of
        // coins in the current `n`.

        // A time complexity is O(amount * coins.length) because we find the fewest number of coins from 0 to amount
        // A space complexity is O(amount) because we save the previous histories until the amount

        int[] history = new int[amount + 1];
        history[0] = 0;

        for (int price = 1; price <= amount; price++) {
            int min = 10001;

            for (int coin : coins) {
                if (coin <= price) {
                    min = Math.min(min, history[price - coin] + 1);
                }
            }

            history[price] = min;
        }

        if (history[amount] > 10000) {
            return -1;
        } else {
            return history[amount];
        }
    }
}