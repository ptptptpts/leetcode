class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int cursor = 1; cursor < nums.length; cursor++) {
            left[cursor] = nums[cursor] * left[cursor - 1];
            right[nums.length - 1 - cursor] = nums[nums.length - 1 - cursor] * right[nums.length - cursor];
        }

        int[] result = new int[nums.length];
        result[0] = right[1];
        result[nums.length - 1] = left[nums.length - 2];
        for (int cursor = 1; cursor < nums.length - 1; cursor++) {
            result[cursor] = left[cursor - 1] * right[cursor + 1];
        }
        return result;
    }
}
