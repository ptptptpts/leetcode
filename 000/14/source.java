class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int cursor = 1; cursor < strs.length; cursor++) {
            int innerCursor = 0;
            String str = strs[cursor];

            if ((str != null) && (str.length() > 0)) {
                while ((innerCursor < prefix.length()) && (innerCursor < str.length())) {
                    if (prefix.charAt(innerCursor) != str.charAt(innerCursor)) {
                        break;
                    }
                    innerCursor++;
                }
            }

            if (innerCursor == 0) {
                prefix = "";
                break;
            } else if (innerCursor < prefix.length()) {
                prefix = prefix.substring(0, innerCursor);
            }
        }

        return prefix;
    }
}
