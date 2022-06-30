import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int pos = 1; pos < nums.length; pos++) {
            if (nums[pos] == nums[pos - 1]) {
                return true;
            }
        }

        return false;
    }
}
