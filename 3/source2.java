class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCounter = new int[256];
        for (int i = 0; i < 256; i++) {
            charCounter[i] = -1;
        }

        int longestLen = 0;
        int start = 0;
        for (int cursor = 0; cursor < s.length(); cursor++) {
            int charNumber = s.charAt(cursor);

            if (charCounter[charNumber] >= 0) {
                int newStart = charCounter[charNumber] + 1;
                for (int innerCursor = start; innerCursor < newStart; innerCursor++) {
                    charCounter[s.charAt(innerCursor)] = -1;
                }
                start = newStart;
                charCounter[charNumber] = cursor;

            } else {
                charCounter[charNumber] = cursor;
                int currentLen = cursor - start + 1;
                if (currentLen > longestLen) {
                    longestLen = currentLen;
                }
            }
        }

        return longestLen;
    }
}
