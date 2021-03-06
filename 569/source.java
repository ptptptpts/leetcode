class Solution {
    public int climbStairs(int n) {
        int[] history = new int[] {0, 1, 2, 0};

        for (int i = 3; i <= n; i++) {
            history[i & 0b11] = history[(i-1) & 0b11] + history[(i-2) & 0b11];
        }

        return history[n & 0b11];
    }
}