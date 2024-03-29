class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];

        for (char c : magazine.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}