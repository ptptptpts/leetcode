class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length);
    }

    private int findMin(int[] nums, int start, int end) {
        if (nums[start] <= nums[end - 1]) {
            return nums[start];
        } else if (nums[end - 2] > nums[end - 1]) {
            return nums[end - 1];
        }

        int middle = (start + end) / 2;
        if (nums[start] > nums[middle - 1]) {
            return findMin(nums, start, middle);
        } else if (nums[middle] > nums[end - 1]) {
            return findMin(nums, middle, end);
        } else if (nums[start] < nums[middle]) {
            return findMin(nums, start, middle);
        } else {
            return findMin(nums, middle, end);
        }
    }
}