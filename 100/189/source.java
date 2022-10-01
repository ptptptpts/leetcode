class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // [0 1 2 3 4 5] k = 2
        // integer 0 <= length - k -> k <= length
        // integer length - k + 1 <= length -> 0 <= k

        // Input: [0 1 2 3 4 5 6] k = 2
        // Expect output: [5 6 0 1 2 3 4]
        // Reverse 1: [4 3 2 1 0 5 6]
        // Reverse 2: [4 3 2 1 0 6 5]
        // Reverse 3: [5 6 0 1 2 3 4]

        rangeReverse(nums, 0, (nums.length - k));
        rangeReverse(nums, nums.length - k, k);
        rangeReverse(nums, 0, nums.length);
    }

    private void rangeReverse(int[] nums, int start, int count) {
        for (int cursor = 0; cursor < count / 2; cursor++) {
            int target = start + count - cursor - 1;
            swap(nums, start + cursor, target);
        }
    }

    private void swap(int[] nums, int cursor, int target) {
        int swap = nums[cursor];
        nums[cursor] = nums[target];
        nums[target] = swap;
    }
}
