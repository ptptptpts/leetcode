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

            if (isSubsequence) {
                int sPos = 0;
                int wordPos = 0;
                for (; (wordPos < word.length()) && (sPos < s.length()); sPos++) {
                    if (s.charAt(sPos) == word.charAt(wordPos)) {
                        wordPos++;
                    }
                }
                
                if (wordPos < word.length()) {
                    isSubsequence = false;
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