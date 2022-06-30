class Solution {
    public int maxSubArray(int[] nums) {
        // Input: array of integer
        // Output: the largest sum that can made by a subarray from the given array

        // What is a range of a length of the given array? 1 <= n <= 10^5
        // What is a range of a integer of element? -10^4 <= n <= 10^4

        // If we know the largest sum of a subarray at the n-1 th position, the largest sub array at
        // the n th position will be a larger one between arr[n] and arr[n] + f(n-1) because
        // subarray is a continuous array.
        // And, we can save the largest value in the given array because we don't need a detail of
        // the previous elements to find the maximum value of `n` th position.

        // A time complexity is O(nums.length) because we need to find the largest value on each position.
        // A space complexity is O(1) because we can save the largest value on the given array.

        int maxSubarray = nums[0];

        for (int pos = 1; pos < nums.length; pos++) {
            nums[pos] = Math.max(nums[pos], nums[pos] + nums[pos - 1]);
            maxSubarray = Math.max(maxSubarray, nums[pos]);
        }

        return maxSubarray;
    }
}
