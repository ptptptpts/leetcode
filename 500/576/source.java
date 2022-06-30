class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int largestSum = nums[0];

        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            largestSum = Math.max(largestSum, currentSum);
        }

        return largestSum;
    }
}