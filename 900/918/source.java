class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int allSum = nums[0];
        int max = nums[0];
        int localMax = nums[0];
        int min = 30001;
        int localMin = 30001;

        for (int i = 1; i < nums.length; i++) {
            allSum += nums[i];
            localMax = Math.max(nums[i], localMax + nums[i]);
            max = Math.max(max, localMax);
            localMin = Math.min(nums[i], localMin + nums[i]);
            min = Math.min(min, localMin);
        }

        return Math.max(max, allSum - min);
    }
}
