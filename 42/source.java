class Solution {
    public int trap(int[] height) {
        int[] scanFromLeft = new int[height.length];
        int[] scanFromRight = new int[height.length];

        int currentTrappedWater = 0;
        int prevHeight = 0;
        for (int pos = 0; pos < height.length; pos++) {
            currentTrappedWater -= height[pos] - prevHeight;
            if (currentTrappedWater < 0) {
                currentTrappedWater = 0;
            }

            scanFromLeft[pos] = currentTrappedWater;            
            prevHeight = height[pos];
        }

        currentTrappedWater = 0;
        prevHeight = 0;
        for (int pos = height.length - 1; pos >= 0; pos--) {
            currentTrappedWater -= height[pos] - prevHeight;
            if (currentTrappedWater < 0) {
                currentTrappedWater = 0;
            }

            scanFromRight[pos] = currentTrappedWater;            
            prevHeight = height[pos];
        }

        int res = 0;

        for (int pos = 0; pos < scanFromLeft.length; pos++) {
            res += scanFromLeft[pos] < scanFromRight[pos] ? scanFromLeft[pos] : scanFromRight[pos];
        }

        return res;
    }
}