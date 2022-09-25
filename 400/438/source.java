import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> positionOfAnagrams = new ArrayList<>();

        if (p.length() <= s.length()) {
            // Count number of alphabets in the string p
            int[] numberOfAlphabetsP = new int[26];
            for (char c : p.toCharArray()) {
                numberOfAlphabetsP[c - 'a']++;
            }

            // Compare the number of alphabets from the string s that has a same length with the string p
            // if the substring has the same number of alphabets, it is an anagram of the string p
            int[] numberOfAlphabetsSubstr = new int[26];
            int substrCursor = 0;
            for (; substrCursor < p.length() - 1; substrCursor++) {
                numberOfAlphabetsSubstr[s.charAt(substrCursor) - 'a']++;
            }
            for (; substrCursor < s.length(); substrCursor++) {
                numberOfAlphabetsSubstr[s.charAt(substrCursor) - 'a']++;

                boolean isAnagram = true;
                for (int alphabetCursor = 0; alphabetCursor < 26; alphabetCursor++) {
                    if (numberOfAlphabetsP[alphabetCursor]
                            != numberOfAlphabetsSubstr[alphabetCursor]) {
                        isAnagram = false;
                        break;
                    }
                }

                int startWindow = substrCursor - p.length() + 1;
                if (isAnagram) {
                    positionOfAnagrams.add(startWindow);
                }

                numberOfAlphabetsSubstr[s.charAt(startWindow) - 'a']--;
            }
        }

        return positionOfAnagrams;
    }
}
