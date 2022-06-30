class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean ret = false;

        int sCursor = 0;
        int tCursor = 0;
        while ((sCursor < s.length()) && (tCursor < t.length())) {
            if (s.charAt(sCursor) == t.charAt(tCursor)) {
                sCursor += 1;
            }
            tCursor += 1;
        }

        if (sCursor == s.length()) {
            ret = true;
        }

        return ret;
    }
}
