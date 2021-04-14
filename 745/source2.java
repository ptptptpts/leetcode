class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        int i = 1;

        while ((i > 0) && (i < n)) {
            i = i * 3;
        }

        if (i == n) {
            return true;
        } else {
            return false;
        }
    }
}