import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] lengthOfWordsInDict = new int[21];
        for (int i = 0; i < lengthOfWordsInDict.length; i++) {
            lengthOfWordsInDict[i] = 0;
        }

        HashSet<String> wordSet = new HashSet<String>();
        for (String word : wordDict) {
            wordSet.add(word);
            lengthOfWordsInDict[word.length()] += 1;
        }

        boolean[] available = new boolean[s.length() + 1];
        available[0] = true;
        for (int i = 1; i < available.length; i++) {
            available[i] = false;
        }

        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            if (available[startIndex]) {
                for (int length = 1; length < lengthOfWordsInDict.length; length++) {
                    if ((lengthOfWordsInDict[length] > 0) && (startIndex + length <= s.length())) {
                        String substring = s.substring(startIndex, startIndex + length);
                        if (wordSet.contains(substring)) {
                            available[startIndex + length] = true;
                        }
                    }
                }
            }
        }

        return available[s.length()];
    }
}
