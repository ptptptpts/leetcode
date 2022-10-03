class Solution {
    public int mySqrt(int x) {
        // square 0 <= x <= 2^16 - 1
        int start = 0;
        int end = Short.MAX_VALUE << 1;

        while (start < end - 1) {
            int middle = (start + end) / 2;
            long middleSquare = (long) middle * middle;

            if (x < middleSquare) {
                end = middle;
            } else if (middleSquare < x) {
                start = middle;
            } else {
                start = middle;
                end = middle + 1;
            }
        }

        return start;
    }
}
