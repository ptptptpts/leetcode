class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int targetIndex = -1;

        while (start < end) {
            int middle = (start + end) >> 1;

            if (target < nums[middle]) {
                end = middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                start = middle;
                end = middle;
                targetIndex = middle;
            }
        }

        return targetIndex;
    }
}
