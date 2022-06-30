class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");

        if (strs.length == 0) {
            return "";
        }

        String shortestStr = strs[0];
        for (int i=1; i < strs.length; i++) {
            if (shortestStr.length() > strs[i].length()) {
                shortestStr = strs[i];
            }
        }

        for (int i=0; i < shortestStr.length(); i++) {
            char currentPrefix = shortestStr.charAt(i);

            for (int j=0; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentPrefix) {
                    return result.toString();
                }
            }

            result.append(currentPrefix);
        }

        return result.toString();
    }
}