class Solution {
    public boolean canJump(int[] nums) {
        // Input: Integer array that contains the maximum length of jump on each position
        // Output: Return true if we can reach the last index

        // What the maximum size of given array? 1 <= n <= 10^4
        // What the maximum value in the given array? 0 <= n <= 10^5

        // Each integer defines the maximum length of jump not a length of jump, so it means
        // if `i`th element is `n`, we can reach any element before and equal `i + n`
        // So, we can save the most far position from the first index and update it on each loop

        boolean ret = false;
        int maximumIndex = 0;

        for (int pos = 0; pos <= maximumIndex; pos++) {
            maximumIndex = Math.max(maximumIndex, pos + nums[pos]);
            if (maximumIndex >= nums.length - 1) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}