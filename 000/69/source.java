class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        long minRange = 1;
        long maxRange = x;

        while (minRange < maxRange) {
            long midRange = (minRange + maxRange) / 2;
            long square = (long)midRange * midRange;

            if (square > x) {
                maxRange = midRange;
            } else if (square < x) {
                if (minRange == midRange) {
                    maxRange = midRange;
                } else {
                    minRange = midRange;
                }
            } else {
                minRange = midRange;
                maxRange = midRange;
            }
        }

        return (int)minRange;
    }
}
