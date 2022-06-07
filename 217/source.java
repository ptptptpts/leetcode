import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> history = new HashSet<>();

        for (int num : nums) {
            if (history.contains(num)) {
                return true;
            } else {
                history.add(num);
            }
        }

        return false;
    }
}