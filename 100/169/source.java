import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int maxNumber = 0;
        for (Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNumber = entry.getKey();
            }
        }
        return maxNumber;
    }
}
