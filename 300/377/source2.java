class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Input: integer array that contains distinct integers, a target integer
        // Output: a number of possible combinations that can add up to target

        // What is range of a number of integer in given nums? 1 <= n <= 200
        // What is a range of a integer in the given nums? 1 <= n <= 1000
        // What is a range of a target integer? 1 <= n <= 1000

        // We can use the same integer as many as we want again, and this problem counts
        // combinations with a different sequence as different one.
        // So, if we assume f(n) is a number of combinations we can add up to n, we can find f(n) by
        // adding all the possible numbers that can make `n` from the given nums.

        // A time complexity is O(n * m) because we need to check all the elements in the given
        // nums and repeat it until 1 to target
        // A space complexity is O(n) because we need to save the previous histories until a target

        int[] counts = new int[target + 1];
        counts[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if ((i - num) >= 0) {
                    counts[i] += counts[i - num];
                }
            }
        }

        return counts[target];
    }
}
