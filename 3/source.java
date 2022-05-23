class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCounter = new int[256];
        for (int i = 0; i < 256; i++) {
            charCounter[i] = -1;
        }

        int longestLen = 0;
        int currentSubStrLen = 0;
        for (int cursor = 0; cursor < s.length(); cursor++) {
            int charNumber = s.charAt(cursor);
            if (charCounter[charNumber] >= 0) {
                int lastPos = charCounter[charNumber];
                currentSubStrLen = 0;
                for (int i = 0; i < 256; i++) {
                    if (charCounter[i] > lastPos) {
                        currentSubStrLen += 1;
                    } else {
                        charCounter[i] = -1;
                    }
                }
            }

            charCounter[charNumber] = cursor;
            currentSubStrLen += 1;
            if (currentSubStrLen > longestLen) {
                longestLen = currentSubStrLen;
            }
        }

        return longestLen;
    }
}
