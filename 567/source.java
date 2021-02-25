class Solution {
    public void moveZeroes(int[] nums) {
        int cursor = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[cursor] = i;
                cursor++;
            }
        }

        for (; cursor < nums.length; cursor++) {
            nums[cursor] = 0;
        }
    }
}