class Solution {
    public int reverse(int x) {
        boolean isPositive = x >= 0;
        long reversed = 0;

        while (x != 0) {
            reversed = (reversed * 10) + (x % 10);
            x = x / 10;
        }

        if (isPositive) {
            if (reversed > Integer.MAX_VALUE) {
                reversed = 0;
            }
        } else {
            if (reversed < Integer.MIN_VALUE) {
                reversed = 0;
            }
        }

        return (int) reversed;
    }
}
