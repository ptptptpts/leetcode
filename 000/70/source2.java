class Solution {
    public int climbStairs(int n) {
        // Input: a number of steps to reach the top.
        // On each time, we can climb 1 or 2 steps.
        // Output: a number of distinct ways to reach the top.

        // We can climb 1 or 2 steps on each time, and it means we can reach to 'i' th step from the
        // 'i-1' or 'i-2' steps. So, a number of distinct ways to 'i' th step f(i) is a sum of
        // f(i-1) and f(i-2).
        // And, f(0) is 1 because there are only one way to remain on the floor. and f(1) is 1
        // because we can't start from f(-1).

        // A time complexity is O(n) because we need to calculate a number of distinct ways from 0
        // to n.
        // A space complexity is O(1) because we don't need to save a previous history or something
        // like that.

        // What is a range of n? 1 <= n <= 45

        int i2 = 0;
        int i1 = 1;
        int i0 = 1;

        for (int step = 2; step <= n; step++) {
            i2 = i1;
            i1 = i0;
            i0 = i1 + i2;
        }

        return i0;
    }
}
