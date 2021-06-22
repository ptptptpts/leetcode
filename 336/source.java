class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (isPalindrome(words[i], words[j])) {
                        List<Integer> palindrome = new ArrayList<>();
                        palindrome.add(i);
                        palindrome.add(j);
                        ret.add(palindrome);
                    }
                }
            }
        }

        return ret;
    }

    private boolean isPalindrome(String a, String b) {
        boolean ret = true;
        String ab = a + b;

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
}