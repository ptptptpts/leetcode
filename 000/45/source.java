class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int startPosition = 0;
        int maxPosition = 0;

        while (maxPosition < (nums.length - 1)) {
            int localMaximum = 0;
            for (int i = startPosition; i <= maxPosition; i++) {
                localMaximum = Math.max(localMaximum, i + nums[i]);
                if (localMaximum >= nums.length) {
                    break;
                }
            }
            startPosition = maxPosition + 1;
            maxPosition = localMaximum;
            jumpCount++;
        }

        return jumpCount;
    }
}