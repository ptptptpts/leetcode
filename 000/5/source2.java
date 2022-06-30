class Solution {
    public String longestPalindrome(String s) {
        int longestStart = 0;
        int longestEnd = 0;

        for (int center = 0; center < s.length(); center++) {
            int currentRadius1 = findLongestPalindrom(s, center, center);
            int currentRadius2 = findLongestPalindrom(s, center, center + 1);
            
            int start;
            int end;
            if (currentRadius1 > currentRadius2) {
                start = center - currentRadius1;
                end = center + currentRadius1;
            } else {
                start = center - currentRadius2;
                end = center + 1 + currentRadius2;
            }

            if ((end - start) > (longestEnd - longestStart)) {
                longestStart = start;
                longestEnd = end;
            }
        }

        return s.substring(longestStart, longestEnd + 1);
    }

    private int findLongestPalindrom(String str, int start, int end) {
        int radius = 0;

        while (((start - radius) >= 0)
            && ((end + radius) < str.length())
            && (str.charAt(start - radius) == str.charAt(end + radius))) {
            radius++;
        }

        return radius - 1;
    }
}
