class Solution {
    public boolean isPalindrome(String s) {
        boolean ret = true;

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                ret = false;
                break;
            }

            start += 1;
            end -= 1;
        }

        return ret;
    }
}
