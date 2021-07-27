import java.util.HashMap;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;

        HashMap<String, Boolean> database = new HashMap<>();
        for (String word : words) {
            if (database.containsKey(word)) {
                if (database.get(word)) {
                    result++;
                }
                continue;
            }

            boolean isSubsequence = true;
            int sPos = 0;

            for (int ch : word.toCharArray()) {
                sPos = s.indexOf(ch, sPos);
                if (sPos == -1) {
                    isSubsequence = false;
                    break;
                } else {
                    sPos++;
                }
            }

            if (isSubsequence) {
                result++;
            }
            database.put(word, isSubsequence);
        }

        return result;
    }
}