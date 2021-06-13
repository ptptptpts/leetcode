class Solution {
    HashMap<String, Integer> mWordsMap = new HashMap<>();
    
    public List<List<Integer>> palindromePairs(String[] words) {        
        putWordsToHashMap(words);
        
        HashSet<List<Integer>> mResultSet = findPalindromePairs(words);

        return copyHashSetResultToList(mResultSet);
    }

    private void putWordsToHashMap(String[] words) {
        for (int i = 0; i < words.length; i++) {
            mWordsMap.put(words[i], i);
        }
    }

    private HashSet<List<Integer>> findPalindromePairs(String[] words) {
        HashSet<List<Integer>> mResultSet = new HashSet<>();

        for (int wordsPos = 0; wordsPos < words.length; wordsPos++) {
            String word = words[wordsPos];

            if (word.length() == 0) {
                continue;
            }

            if (isPalindrome(word)) {
                addEmptyStringPair(mResultSet, wordsPos);
            }

            for (int len = 1; len <= word.length(); len++) {
                findFrontSubstringPalindrome(mResultSet, wordsPos, word, len);
                findEndSubstringPalindrome(mResultSet, wordsPos, word, len);
            }
        }

        return mResultSet;
    }

    private void addEmptyStringPair(HashSet<List<Integer>> mResultSet, int pos) {
        Integer emptyStringPos = mWordsMap.get("");
        if (emptyStringPos != null) {
            mResultSet.add(Arrays.asList(pos, emptyStringPos));
            mResultSet.add(Arrays.asList(emptyStringPos, pos));
        }
    }

    private void findFrontSubstringPalindrome(HashSet<List<Integer>> mResultSet, int pos, String word, int len) {
        String reverseSubstr = getReverseString(word.substring(0, len));
        Integer palindromePos = mWordsMap.get(reverseSubstr);

        if (palindromePos != null) {
            addPairIfPalindrome(mResultSet, word, pos, reverseSubstr, palindromePos);
        }
    }

    private void findEndSubstringPalindrome(HashSet<List<Integer>> mResultSet, int pos, String word, int len) {
        String reverseSubstr = getReverseString(word.substring(len, word.length()));
        Integer palindromePos = mWordsMap.get(reverseSubstr);

        if ((palindromePos != null)) {
            addPairIfPalindrome(mResultSet, reverseSubstr, palindromePos, word, pos);
        }
    }

    private void addPairIfPalindrome(HashSet<List<Integer>> mResultSet, String wordA, int wordAPos, String wordB, int wordBPos) {
        if ((wordAPos != wordBPos) && isPalindrome(wordA + wordB)) {
            mResultSet.add(Arrays.asList(wordAPos, wordBPos));
        }
    }

    private String getReverseString(String word) {
        StringBuilder sb = new StringBuilder();

        for (int pos = word.length() - 1; pos >= 0; pos--) {
            sb.append(word.charAt(pos));
        }

        return sb.toString();
    }

    private boolean isPalindrome(String ab) {
        boolean ret = true;

        if (ab.length() > 1) {
            int half = ab.length() / 2;
            int length = ab.length();

            for (int pos = 0; pos < half; pos++) {
                if (ab.charAt(pos) != ab.charAt(length - pos - 1)) {
                    ret = false;
                    break;
                }
            }
        }

        return ret;
    }

    private List<List<Integer>> copyHashSetResultToList(HashSet<List<Integer>> mResultSet) {
        List<List<Integer>> ret = new ArrayList<>();
        for (List<Integer> result : mResultSet) {
            ret.add(result);
        }
        return ret;
    }
}