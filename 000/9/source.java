class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        for (int temp = x; temp > 0; temp /= 10) {
            reverse = (reverse * 10) + (temp % 10);
        }
        return reverse == x;
    }
}
