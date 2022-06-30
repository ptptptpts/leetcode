class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrom = "";
        int longestStart = 0;
        int longestEnd = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start - 1, 0);
            while (!isPalindrom(s, start, i)) {
                start += 1;
            }

            if ((i - start + 1) > (longestEnd - longestStart + 1)) {
                longestEnd = i;
                longestStart = start;
            }
        }

        return s.substring(longestStart, longestEnd + 1);
    }

    private boolean isPalindrom(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start += 1;
                end -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
