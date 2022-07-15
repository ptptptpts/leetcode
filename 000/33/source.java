class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            boolean isRotated = nums[left] > nums[right - 1];
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                if (isRotated) {
                    if (nums[right - 1] > nums[middle]) {
                        if (nums[right - 1] == target) {
                            return right - 1;
                        } else if (nums[right - 1] < target) {
                            right = middle;
                        } else {
                            left = middle + 1;
                        }
                    } else if ((right - 1) == middle) {
                        right = middle;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    left = middle + 1;
                }
            } else {
                if (isRotated) {
                    if (nums[left] < nums[middle]) {
                        if (nums[left] == target) {
                            return left;
                        } else if (nums[left] < target) {
                            right = middle;
                        } else {
                            left = middle + 1;
                        }
                    } else {
                        right = middle;
                    }
                } else {
                    right = middle;
                }
            }
        }

        return -1;
    }
}