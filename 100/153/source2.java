class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else if (nums[0] > nums[1]) {
            return nums[1];
        }

        int maximumElement = 0;
        int minimumElement = nums.length;

        while (maximumElement < (minimumElement - 2)) {
            int middle = (maximumElement + minimumElement) / 2;

            // peak is in left or middle
            if ((nums[maximumElement] > nums[middle])) {
                minimumElement = middle + 1;
            // peak is in right
            } else if (nums[maximumElement] < nums[middle]) {
                maximumElement = middle;
            }
        }

        return nums[minimumElement - 1];
    }
}
