import java.util.ArrayList;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] subsLength = new int[text1.length()];
        for (int i = 0; i < text1.length(); i++) {
            subsLength[i] = 0;
        }

        int longest = 0;

        for (int cursor2 = 0; cursor2 < text2.length(); cursor2++) {
            char c2 = text2.charAt(cursor2);

            int currentLongest = 0;
            for (int cursor1 = 0; cursor1 < text1.length(); cursor1++) {
                char c1 = text1.charAt(cursor1);

                if (((currentLongest + 1) > subsLength[cursor1])
                        && (c2 == c1)) {
                    subsLength[cursor1] = currentLongest + 1;
                    longest = Math.max(longest, currentLongest + 1);

                } else {
                    currentLongest = Math.max(currentLongest, subsLength[cursor1]);
                }
            }
        }

        return longest;
    }
}
