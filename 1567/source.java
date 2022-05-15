class Solution {
    public int getMaxLen(int[] nums) {
        int longestPositive = 0;

        int nonZeroStreek = 0;
        boolean isNegative = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nonZeroStreek = 0;
                isNegative = false;
            } else {
                nonZeroStreek += 1;
                if (nums[i] < 0) {
                    isNegative = !isNegative;
                }
                if (!isNegative) {
                    longestPositive = Math.max(longestPositive, nonZeroStreek);
                }
            }
        }

        nonZeroStreek = 0;
        isNegative = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                nonZeroStreek = 0;
                isNegative = false;
            } else {
                nonZeroStreek += 1;
                if (nums[i] < 0) {
                    isNegative = !isNegative;
                }
                if (!isNegative) {
                    longestPositive = Math.max(longestPositive, nonZeroStreek);
                }
            }
        }

        return longestPositive;
    }
}
