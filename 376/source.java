class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int numberOfPeeks = 1;

        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (diff > 0) {
                if (nums[i] < nums[i-1]) {
                    diff = nums[i] - nums[i-1];
                    numberOfPeeks += 1;
                }
            } else if (diff < 0) {
                if (nums[i] > nums[i-1]) {
                    diff = nums[i] - nums[i-1];
                    numberOfPeeks += 1;
                }
            } else {
                if (nums[i] != nums[i-1]) {
                    diff = nums[i] - nums[i-1];
                    numberOfPeeks += 1;
                }
            }
        }

        return numberOfPeeks;
    }
}
