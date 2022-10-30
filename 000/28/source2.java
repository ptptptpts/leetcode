class Solution {
    public int strStr(String haystack, String needle) {
        int needleIndex = -1;

        for (int haystackPos = 0; haystackPos <= (haystack.length() - needle.length()); haystackPos++) {
            if (isNeedleAtPos(haystack, needle, haystackPos)) {
                needleIndex = haystackPos;
                break;
            }
        }

        return needleIndex;
    }

    private boolean isNeedleAtPos(String haystack, String needle, int haystackCursor) {
        boolean isNeedleString = true;

        for (int needlePos = 0; needlePos < needle.length(); needlePos++) {
            if (haystack.charAt(haystackCursor + needlePos) != needle.charAt(needlePos)) {
                isNeedleString = false;
                break;
            }
        }

        return isNeedleString;
    }
}
