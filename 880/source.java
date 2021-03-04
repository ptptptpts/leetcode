class Solution {
    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result *= 10;
            result += x % 10;
            x = x / 10;
        }

        if (Math.abs(result) > Math.pow(2, 31)) {
            return 0;
        } else {
            return (int)result;
        }
    }
}