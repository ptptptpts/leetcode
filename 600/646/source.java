class Solution {
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void reverse(int[] nums, int start, int end) {
        int size = (end - start) / 2;
        for (int i = 0; i < size; i++) {
            swap(nums, start + i, end - 1 - i);
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length - k);
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length);
    }
}