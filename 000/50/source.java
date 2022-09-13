class Solution {
    public double myPow(double x, int n) {
        double result = 1;

        if (n > 0) {
            double currentPow = x;
            int currentMask = 1;
            for (int bitPosition = 1; bitPosition <= 31; bitPosition++) {
                if ((n & currentMask) > 0) {
                    result *= currentPow;
                }
                currentMask = currentMask << 1;
                currentPow *= currentPow;
            }
        } else if (n < 0) {
            long ln = (long) n * -1;
            double currentPow = 1 / x;
            int currentMask = 1;
            for (int bitPosition = 1; bitPosition <= 32; bitPosition++) {
                if ((ln & currentMask) > 0) {
                    result *= currentPow;
                }
                currentMask = currentMask << 1;
                currentPow *= currentPow;
            }
        }

        return result;
    }
}
