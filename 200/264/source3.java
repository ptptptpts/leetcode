class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int cursorTwo = 0;
        int cursorThree = 0;
        int cursorFive = 0;
        int twoFactor = uglyNumbers[cursorTwo] * 2;
        int threeFactor = uglyNumbers[cursorThree] * 3;
        int fiveFactor = uglyNumbers[cursorFive] * 5;
        for (int i = 1; i < n; i++) {
            int minUgly = Math.min(Math.min(twoFactor, threeFactor), fiveFactor);
            uglyNumbers[i] = minUgly;

            if (minUgly == twoFactor) {
                cursorTwo += 1;
                twoFactor = uglyNumbers[cursorTwo] * 2;
            }
            if (minUgly == threeFactor) {
                cursorThree += 1;
                threeFactor = uglyNumbers[cursorThree] * 3;
            }
            if (minUgly == fiveFactor) {
                cursorFive += 1;
                fiveFactor = uglyNumbers[cursorFive] * 5;
            }
        }

        return uglyNumbers[n - 1];
    }
}
