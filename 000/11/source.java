class Solution {
    public int maxArea(int[] height) {        
        int leftCursor = 0;
        int rightCursor = height.length - 1;
        int leftWall = height[leftCursor];
        int rightWall = height[rightCursor];
        int waterline = Math.min(leftWall, rightWall);
        int mostWater = waterline * (rightCursor - leftCursor);

        while (leftCursor < rightCursor) {
            if (leftWall < rightWall) {
                leftCursor += 1;
                if (height[leftCursor] > leftWall) {
                    leftWall = height[leftCursor];
                }
                waterline = Math.min(leftWall, rightWall);
                mostWater = Math.max(mostWater, waterline * (rightCursor - leftCursor));
                
            } else {
                rightCursor -= 1;
                if (height[rightCursor] > rightWall) {
                    rightWall = height[rightCursor];
                }
                waterline = Math.min(leftWall, rightWall);
                mostWater = Math.max(mostWater, waterline * (rightCursor - leftCursor));
            }
        }

        return mostWater;
    }
}
