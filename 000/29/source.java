class Solution {
    public int divide(int dividend, int divisor) {
        long quotient = 0;
        long longDividend = dividend;
        long longDivisor = divisor;

        boolean isNegative = false;
        if (longDividend < 0) {
            longDividend = longDividend * - 1;
            isNegative = true;
        }
        if (longDivisor < 0) {
            longDivisor = longDivisor * - 1;
            isNegative = !isNegative;
        }

        long numberOfShift = 1;
        while ((longDivisor & 0x80000000) == 0) {
            numberOfShift = numberOfShift << 1;
            longDivisor = longDivisor << 1;
        }

        while (numberOfShift > 0) {
            while (longDividend >= longDivisor) {
                longDividend = longDividend - longDivisor;
                quotient += numberOfShift;
            }
            numberOfShift = numberOfShift >> 1;
            longDivisor = longDivisor >> 1;
        }

        if (isNegative) {
            quotient = quotient * -1;
        }

        if (quotient > Integer.MAX_VALUE) {
            quotient = Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            quotient = Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}
