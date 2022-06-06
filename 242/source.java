class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCounter = new int[26];
        int[] tCounter = new int[26];
        for (int i = 0; i < 26; i++) {
            sCounter[i] = 0;
            tCounter[i] = 0;
        }

        for (int pos = 0; pos < s.length(); pos++) {
            sCounter[s.charAt(pos) - 'a']++;
        }
        for (int pos = 0; pos < t.length(); pos++) {
            tCounter[t.charAt(pos) - 'a']++;
        }

        boolean ret = true;
        for (int i = 0; i < 26; i++) {
            if (sCounter[i] != tCounter[i]) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}