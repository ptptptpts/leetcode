class Solution {
    public boolean search(int[] nums, int target) {
        // Binary search, but take care of the rotate k
        // 2) middle > target
        // 2-1) left > middle -> peak is in the left, target is in the left
        // 2-2) left <= middle -> peak is in the right or left is the peak
        // 2-2-1) left <= target -> target is in the left
        // 2-2-2) left > target -> target is in the right
        // 3) middle <= target
        // 3-1) left > middle -> peak is in the left
        // 3-1-1) left > target -> target is in the right
        // 3-1-2) left <= target -> target is in the left
        // 3-2) left <= middle -> peak is in the right, target is in the right

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = (left + right) / 2;

            if ((nums[middle] == nums[left]) && (nums[middle] == nums[right - 1])) {
                if (nums[middle] == target) {
                    left = middle;
                    right = middle;
                } else {
                    left = left + 1;
                    right = right - 1;
                }
            } else if (nums[middle] > target) {
                if (nums[left] > nums[middle]) {
                    // target < nums[middle] < nums[left]
                    right = middle;
                } else {
                    if (nums[left] > target) {
                        // target < nums[left] <= nums[middle]
                        left = middle + 1;
                    } else {
                        // nums[left] <= target < nums[middle]
                        right = middle;
                    }
                }
            } else if (nums[middle] < target) {
                if (nums[left] > nums[middle]) {
                    if (nums[left] > target) {
                        // nums[middle] < target < nums[left]
                        left = middle + 1;
                    } else {
                        // nums[middle] < target >= nums[left]
                        right = middle;
                    }
                } else {
                    // nums[left] <= nums[middle] < target
                    left = middle + 1;
                }
            } else {
                left = middle;
                right = middle;
                break;
            }
        }

        if (left < nums.length) {
            return nums[left] == target;
        } else {
            return false;
        }
    }
}
