class Solution {
    public int findPeakElement(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        int leftWindow = 0;
        int rightWindow = nums.length;

        while (leftWindow < (rightWindow - 1)) {
            // If some element is increasing from its left element, it means the peak will be in the right side of the element.
            int middle = (leftWindow + rightWindow) / 2;

            if (nums[middle - 1] < nums[middle]) {
                leftWindow = middle;
            } else {
                rightWindow = middle;
            }
        }

        return leftWindow;
    }
}
