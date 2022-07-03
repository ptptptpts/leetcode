class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Input: a String
        // Output: a length of the longest substring can made from the given string s

        // What is a range of the given string s? 0 <= s.length <= 5 * 10^4
        // Which characters in the given string s? S contains a English letters, digits, symbols and spaces.

        // First we need to make an array to record each character is included in the substring or
        // not. It will check each character by a boolean value.
        // Next, we need to use two cursors that save a start and end point of a current substring.
        // On each loop, we will move an end of substring to the next character and if the next
        // character is already in a substring, we'll move a start of a substring until this
        // character is shown. While moving the start cursor, we'll reset the previous histories
        // until the last character as false.
        // After checking the current character, we'll compare a length of a current substring to
        // the last longest substring.

        // A time complexity is O(n) because we need to traverse the entire string. We use two
        // cursors, but it does not affect on a time complexity because they don't move to backward.
        // A space complexity is O(1) because we always save the previous history about on each
        // english character.

        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        boolean[] histories = new boolean[256];
        int maximumLength = 0;
        int startPosition = 0;

        for (int endPosition = 0; endPosition < s.length(); endPosition++) {
            char end = s.charAt(endPosition);

            if (!histories[end]) {
                histories[end] = true;
            } else {
                while (startPosition < endPosition) {
                    char start = s.charAt(startPosition);
                    startPosition++;
                    if (start != end) {
                        histories[start] = false;
                    } else {
                        break;
                    }
                }
            }

            maximumLength = Math.max(maximumLength, endPosition - startPosition + 1);
        }

        return maximumLength;
    }
}
