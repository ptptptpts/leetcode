import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        HashMap<Integer, Integer> numSet = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (numSet.containsKey(key)) {
                result[0] = numSet.get(key);
                result[1] = i;
                break;
            } else {
                numSet.put(nums[i], i);
            }
        }

        return result;
    }
}
