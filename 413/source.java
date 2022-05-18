class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int numberOfSlices = 0;

        int currentSliceSize = 2;
        int currentSliceDiff = nums[1] - nums[0];
        for (int pos = 2; pos < nums.length; pos++) {
            int diff = nums[pos] - nums[pos - 1];
            if (currentSliceDiff == diff) {
                currentSliceSize += 1;
                if (currentSliceSize >= 3) {
                    numberOfSlices += currentSliceSize - 2;
                }
            } else {
                currentSliceSize = 2;
                currentSliceDiff = diff;
            }
        }

        return numberOfSlices;
    }
}