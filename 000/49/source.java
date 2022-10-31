import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramHashMap = new HashMap<>();

        for (String str : strs) {
            int[] charCounter = new int[26];

            for (int pos = 0; pos < str.length(); pos++) {
                charCounter[str.charAt(pos) - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder("");
            for (int pos = 0; pos < 26; pos++) {
                for (int counter = 0; counter < charCounter[pos]; counter++) {
                    keyBuilder.append('a' + pos);
                }
            }

            List<String> anagrams =
                    anagramHashMap.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>());
            anagrams.add(str);
        }

        List<List<String>> anagramsGroup = new ArrayList<>();
        anagramHashMap.forEach((key, anagrams) -> anagramsGroup.add(anagrams));
        return anagramsGroup;
    }
}
