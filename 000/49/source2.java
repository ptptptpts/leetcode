import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramHashMap = new HashMap<>();

        for (String str : strs) {
            char[] charString = str.toCharArray();
            Arrays.sort(charString);
            String keyString = new String(charString);

            List<String> anagrams = anagramHashMap.computeIfAbsent(keyString, k -> new ArrayList<>());
            anagrams.add(str);
        }

        return new ArrayList<>(anagramHashMap.values());
    }
}
