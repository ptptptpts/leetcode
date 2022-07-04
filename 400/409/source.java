class Solution {
    public int longestPalindrome(String s) {
        int[] counter = new int[52];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                counter[c - 'a']++;
            } else {
                counter[c - 'A' + 26]++;
            }
        }

        int ret = 0;
        int maxOdd = 0;
        for (int count : counter) {
            if ((count % 2) == 0) {
                ret += count;
            } else {
                maxOdd = 1;
                ret += count - 1;
            }
        }
        ret += maxOdd;
        return ret;
    }
}
