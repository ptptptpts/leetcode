class Solution {
    public int maxSubArray(int[] nums) {
        int max = -10001;

        int localMax = -10001;
        for (int num : nums) {
            if (localMax > 0) {
                localMax += num;
            } else {
                localMax = num;
            }
            max = Math.max(localMax, max);
        }

        return max;
    }
}