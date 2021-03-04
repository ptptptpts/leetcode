class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            int l = len - 1 - i;
            char tmp = s[i];
            s[i] = s[l];
            s[l] = tmp;
        }
    }
}