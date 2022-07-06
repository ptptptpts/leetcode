class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int left = 1;
        for (int cursor = 0; cursor < nums.length; cursor++) {
            result[cursor] = left;
            left = nums[cursor] * left;
        }

        int right = 1;
        for (int cursor = nums.length - 1; cursor >= 0; cursor--) {
            result[cursor] *= right;
            right = nums[cursor] * right;
        }

        return result;
    }
}
