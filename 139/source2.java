import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Input: String s and directory of String wordDict
        // Output: true if s can be segmented into words in the wordDict

        // What is a range of a length of the s? 1 <= n <= 300
        // What is a range of a word in the wordDict? 1 <= n <= 20
        // What is a range of a size of the wordDict? 1 <= n <= 1000
        // Does the s and wordDict contains a English letters? They contain only a lowercase letter
        // Is a word in the wordDict unique? Yes

        // It is similar with a coin problem. If we know the previous available strings before the
        // `n` th character of the given string S, we can find it is available or not by finding the
        // string has one of a word as a postfix and a remained string as a previous history.
        // For example, if we want to find the string 'abcdefg' is available or not and a wordDict
        // has a ['a', 'bc, 'de', 'fg', 'g'], we need find words that the string is end with
        // and it will be ['fg', 'g']. And next, the previous history has ['a', 'abc', 'abcde'], so
        // only the 'fg' is available prefix. Next, the 'abcdefg' has any available prefix from the
        // wordDict, the 'abcdefg' is an available string.
        // To manage the previous history, a HashSet is good to find a string in O(1) complexity.

        // A time complexity is O(s.length * wordDict.size() * wordDict[0].length)
        // A space complexity is O(s.length)

        HashSet<String> history = new HashSet<>();
        history.add("");

        for (int pos = 0; pos < s.length(); pos++) {
            StringBuilder substr = new StringBuilder(s.substring(0, pos));

            if (history.contains(substr.toString())) {
                for (String word : wordDict) {
                    history.add(substr + word);
                }
            }

            if (history.contains(s)) {
                break;
            }
        }

        return history.contains(s);
    }
}
