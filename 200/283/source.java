class Solution {
    public void moveZeroes(int[] nums) {
        int moveCursor = 0;
        for (int lead = 0; lead < nums.length; lead++) {
            if (nums[lead] != 0) {
                nums[moveCursor] = nums[lead];
                moveCursor++;
            }
        }
        while (moveCursor < nums.length) {
            nums[moveCursor] = 0;
            moveCursor++;
        }
    }
}
