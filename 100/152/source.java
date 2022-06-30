class Solution {
    public int maxProduct(int[] nums) {
        int maximum = 0x80000000;
        int localMax = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                localMax = 1;
                maximum = Math.max(maximum, 0);
            } else {
                localMax = localMax * nums[i];
                maximum = Math.max(maximum, localMax);
            }
        }

        localMax = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                localMax = 1;
                maximum = Math.max(maximum, 0);
            } else {
                localMax = localMax * nums[i];
                maximum = Math.max(maximum, localMax);
            }
        }

        return maximum;
    }
}
