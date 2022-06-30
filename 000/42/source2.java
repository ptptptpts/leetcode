class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int res = 0;

        int leftCursor = 0;
        int rightCursor = height.length - 1;

        int leftTallestHeight = height[leftCursor];
        int rightTallestHeight = height[rightCursor];

        while (leftCursor != rightCursor) {
            if (height[leftCursor] < height[rightCursor]) {
                leftCursor++;
                if (height[leftCursor] >= leftTallestHeight) {
                    leftTallestHeight = height[leftCursor];
                } else {
                    res += leftTallestHeight - height[leftCursor];
                }

            } else {
                rightCursor--;
                if (height[rightCursor] >= rightTallestHeight) {
                    rightTallestHeight = height[rightCursor];
                } else {
                    res += rightTallestHeight - height[rightCursor];
                }
            }
        }

        return res;
    }
}