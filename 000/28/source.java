class Solution {
    public int strStr(String haystack, String needle) {
        int needleIndex = -1;

        for (int cursor = 0; cursor <= (haystack.length() - needle.length()); cursor++) {
            if (isNeedleString(haystack, needle, cursor)) {
                needleIndex = cursor;
                break;
            }
        }

        return needleIndex;
    }

    private boolean isNeedleString(String haystack, String needle, int startHaystack) {
        boolean isNeedle = true;

        if (needle.length() <= (haystack.length() - startHaystack)) {
            for (int cursor = 0; cursor < needle.length(); cursor++) {
                if (haystack.charAt(startHaystack + cursor) != needle.charAt(cursor)) {
                    isNeedle = false;
                    break;
                }
            }
        } else {
            isNeedle = false;
        }

        return isNeedle;
    }
}
