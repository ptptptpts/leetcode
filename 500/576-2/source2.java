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
        profits[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int currentPos = i & 0b11;
            int prevPos = (i - 1) & 0b11;
            int pprevPos = (i - 2) & 0b11;
            profits[currentPos] = Math.max(profits[prevPos], profits[pprevPos] + nums[i]);
        }

        return profits[(nums.length - 1) & 0b11];
    }
}