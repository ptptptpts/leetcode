class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];

        int middle = 0;
        while ((nums[middle] < 0) && (middle < nums.length - 1)) {
            middle++;
        }
        if (middle > 0) {
            if (Math.abs(nums[middle]) > Math.abs(nums[middle - 1])) {
                middle--;
            }
        }
        output[0] = nums[middle] * nums[middle];

        int backwardCursor = middle - 1;
        int forwardCursor = middle + 1;
        int backwardAbs =
                (backwardCursor >= 0) ? Math.abs(nums[backwardCursor]) : Integer.MAX_VALUE;
        int forwardAbs =
                (forwardCursor < nums.length) ? Math.abs(nums[forwardCursor]) : Integer.MAX_VALUE;
        int outputCursor = 1;

        while (outputCursor < nums.length) {
            if (backwardAbs < forwardAbs) {
                output[outputCursor] = backwardAbs * backwardAbs;
                backwardCursor--;
                backwardAbs =
                        (backwardCursor >= 0) ? Math.abs(nums[backwardCursor]) : Integer.MAX_VALUE;
            } else {
                output[outputCursor] = forwardAbs * forwardAbs;
                forwardCursor++;
                forwardAbs =
                        (forwardCursor < nums.length) ? Math.abs(nums[forwardCursor]) : Integer.MAX_VALUE;
            }

            outputCursor++;
        }

        return output;
    }
}
