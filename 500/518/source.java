class Solution {
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            combinations[i] = 0;
        }

        combinations[0] = 1;
        for (int coin : coins) {
            for (int cost = coin; cost <= amount; cost++) {
                combinations[cost] += combinations[cost - coin];
            }
        }

        return combinations[amount];
    }
}
