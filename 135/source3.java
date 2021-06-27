// Improve the source2.java

class Solution {
    private static final int UPWARD = 1;
    private static final int FLAT = 0;
    private static final int DOWNWARD = -1;

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int result = 0;

        // Assume the minumum number of candies as 0
        int upPeak = 0;
        int downPeak = 0;
        int previousSlope  = 0;
        int currentSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            currentSlope = (ratings[i] > ratings[i-1]) ? UPWARD :
                (ratings[i] < ratings[i-1]) ? DOWNWARD : FLAT;

            if (currentSlope == UPWARD) {
                if (previousSlope == DOWNWARD) {
                    result += calculatePeakSize(upPeak, downPeak);
                    upPeak = 1;
                    downPeak = 0;
                } else {
                    upPeak += 1;
                }
            } else if (currentSlope == FLAT) {
                result += calculatePeakSize(upPeak, downPeak);
                upPeak = 0;
                downPeak = 0;
            } else if (currentSlope == DOWNWARD) {
                downPeak += 1;
            }

            previousSlope = currentSlope;
        }
        result += calculatePeakSize(upPeak, downPeak);

        // Give a candy to all children
        return result + ratings.length;
    }

    private int calculatePeakSize(int upPeak, int downPeak) {
        int result = 0;

        if (upPeak == 0) {
            result += (downPeak * (downPeak + 1)) / 2;
        } else if (downPeak == 0) {
            result += (upPeak * (upPeak + 1)) / 2;
        } else {
            result += (upPeak * (upPeak + 1)) / 2;
            result += (downPeak * (downPeak + 1)) / 2;
            if (upPeak > downPeak) {
                result -= downPeak;
            } else {
                result -= upPeak;
            }
        }

        return result;
    }
}
