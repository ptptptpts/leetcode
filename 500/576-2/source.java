class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int [] profits = new int[] { 0, 0, 0, 0 };

        profits[0] = nums[0];
        profits[1] = nums[1];
        profits[2] = nums[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            int currentPos = i % 4;
            int pprevPos = (i - 2) % 4;
            int ppprevPos = (i - 3) % 4;
            profits[currentPos] = Math.max(profits[pprevPos], profits[ppprevPos]) + nums[i];
        }

        int lastPos = (nums.length - 1) % 4;
        int prevLastPos = (nums.length - 2) % 4;
        return Math.max(profits[lastPos], profits[prevLastPos]);
    }
}