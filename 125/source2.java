class Solution {
    public boolean isPalindrome(String s) {
        boolean ret = true;

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if (!Character.isAlphabetic(startChar) && !Character.isDigit(startChar)) {
                start += 1;
            } else if (!Character.isAlphabetic(endChar) && !Character.isDigit(endChar)) {
                end -= 1;
            } else {
                startChar = Character.toLowerCase(startChar);
                endChar = Character.toLowerCase(endChar);

                if (startChar != endChar) {
                    ret = false;
                    break;
                }

                start += 1;
                end -= 1;
            }
        }

        return ret;
    }
}
