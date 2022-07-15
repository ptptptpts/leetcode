class Solution {
    public boolean backspaceCompare(String s, String t) {
        boolean ret = true;

        int sBackspaces = 0;
        int tBackspaces = 0;
        int sCursor = s.length() - 1;
        int tCursor = t.length() - 1;

        while ((sCursor >= 0) || (tCursor >= 0)) {
            if ((sCursor >= 0) && (s.charAt(sCursor) == '#')) {
                sCursor--;
                sBackspaces++;
            } else if ((tCursor >= 0) && (t.charAt(tCursor) == '#')) {
                tCursor--;
                tBackspaces++;
            } else if ((sCursor >= 0) && (sBackspaces > 0)) {
                sCursor--;
                sBackspaces--;
            } else if ((tCursor >= 0) && (tBackspaces > 0)) {
                tCursor--;
                tBackspaces--;
            } else if ((sCursor < 0) || (tCursor < 0)) {
                ret = false;
                break;
            } else {
                if (s.charAt(sCursor) != t.charAt(tCursor)) {
                    ret = false;
                    break;
                } else {
                    sCursor--;
                    tCursor--;
                }
            }
        }

        return ret;
    }
}
