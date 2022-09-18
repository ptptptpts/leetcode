class Solution {
    public void sortColors(int[] nums) {
        int leftCursor = 0;
        int rightCursor = nums.length - 1;
        int redCursor = 0;
        int blueCursor = nums.length - 1;

        while (leftCursor <= rightCursor) {
            if (nums[leftCursor] == 0) {
                int temp = nums[leftCursor];
                nums[leftCursor] = nums[redCursor];
                nums[redCursor] = temp;
                redCursor++;
                leftCursor++;
            } else if (nums[rightCursor] == 2) {
                int temp = nums[rightCursor];
                nums[rightCursor] = nums[blueCursor];
                nums[blueCursor] = temp;
                blueCursor--;
                rightCursor--;
            } else if (nums[leftCursor] == 1) {
                leftCursor++;
            } else if (nums[rightCursor] == 1) {
                rightCursor--;
            } else if (nums[leftCursor] == 2) {
                int temp = nums[leftCursor];
                nums[leftCursor] = nums[blueCursor];
                nums[blueCursor] = temp;
                if (blueCursor == rightCursor) {
                    rightCursor--;
                }
                blueCursor--;
            } else if (nums[rightCursor] == 0) {
                int temp = nums[rightCursor];
                nums[rightCursor] = nums[redCursor];
                nums[redCursor] = temp;
                if (redCursor == leftCursor) {
                    leftCursor++;
                }
                redCursor++;
            }
        }
    }
}
