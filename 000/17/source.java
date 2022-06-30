import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[][] DICT = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<StringBuilder> currentStrs = new ArrayList<>();
        currentStrs.add(new StringBuilder(""));

        for (int i = 0; i < digits.length(); i++) {
            List<StringBuilder> nextStrs = new ArrayList<>();
            int dictPosition = digits.charAt(i) - '2';

            for (StringBuilder str : currentStrs) {
                for (char c : DICT[dictPosition]) {
                    nextStrs.add(new StringBuilder(str.append(c)));
                    str.deleteCharAt(i);
                }
            }

            currentStrs = nextStrs;
        }

        List<String> ret = new ArrayList<>();
        for (StringBuilder sb : currentStrs) {
            ret.add(sb.toString());
        }
        return ret;
    }
}
