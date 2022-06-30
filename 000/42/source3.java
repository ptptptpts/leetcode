class Solution {
    public int trap(int[] height) {
        int[] trappedWater = new int[height.length];
        for (int i = 0; i < trappedWater.length; i++) {
            trappedWater[i] = 0;
        }

        int currentPeek = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            if ((height[i] >= height[i - 1]) && (height[i] > currentPeek)) {
                currentPeek = height[i];
            } else {
                trappedWater[i] = currentPeek - height[i];
            }
        }
        
        currentPeek = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            if ((height[i] >= height[i + 1]) && (height[i] > currentPeek)) {
                currentPeek = height[i];
                trappedWater[i] = 0;
            } else {
                int currentTrappedWater = currentPeek - height[i];
                if (currentTrappedWater < trappedWater[i]) {
                    trappedWater[i] = currentTrappedWater;
                }
            }
        }

        int unitOfTrappedWater = 0;
        for (int water : trappedWater) {
            System.out.print(String.valueOf(water));
            unitOfTrappedWater += water;
        }
        return unitOfTrappedWater;
    }
}
