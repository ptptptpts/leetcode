class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int middle = (start + end) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }
}
