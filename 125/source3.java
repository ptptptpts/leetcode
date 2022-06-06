class Solution {
    public boolean isPalindrome(String s) {
        // Input: String s
        // Output: True if the String s is a palindrome.

        // What is a length of the String s? 1 <= n <= 2 * 10^5
        // What kinds of a character the String s contains? All kinds of characters.
        // But you should convert all uppercase letters is same with a lowercase letter, and ignore non-alphanumeric characters.

        // A palindrome means the `i`th character from starting is same with the `i`th character from end.
        // It means we can compare each character from start and end by using two different cursors.
        // If they crosses without finding a different character, it will be a palindrome.

        boolean ret = true;
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char cStart = s.charAt(start);
            char cEnd = s.charAt(end);

            if (!Character.isAlphabetic(cStart) && !Character.isDigit(cStart)) {
                start++;
            } else if (!Character.isAlphabetic(cEnd) && !Character.isDigit(cEnd)) {
                end--;
            } else {
                cStart = Character.toLowerCase(cStart);
                cEnd = Character.toLowerCase(cEnd);

                if (cStart == cEnd) {
                    start++;
                    end--;
                } else {
                    ret = false;
                    break;
                }
            }
        }

        return ret;
    }
}