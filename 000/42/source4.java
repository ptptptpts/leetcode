class Solution {
    public int trap(int[] height) {
        int water = 0;

        int leftPeek = height[0];
        int rightPeek = height[height.length - 1];
        int leftCursor = 0;
        int rightCursor = height.length - 1;
        while (leftCursor != rightCursor) {
            if (leftPeek < rightPeek) {
                leftCursor++;
                if (height[leftCursor] >= leftPeek) {
                    leftPeek = height[leftCursor];
                } else {
                    water += leftPeek - height[leftCursor];
                }
            } else {
                rightCursor--;
                if (height[rightCursor] >= rightPeek) {
                    rightPeek = height[rightCursor];
                } else {
                    water += rightPeek - height[rightCursor];
                }
            }
        }

        return water;
    }
}
