import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        int closestDiff = Math.abs(closest - target);

        for (int pos = 0; pos < nums.length - 2; pos++) {
            int start = pos + 1;
            int end = nums.length - 1;
            int num = nums[pos];

            while (start < end) {
                int sum = num + nums[start] + nums[end];
                int currentDiff = Math.abs(sum - target);

                if (currentDiff < closestDiff) {
                    closest = sum;
                    closestDiff = Math.abs(closest - target);
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    break;
                }
            }
        }

        return closest;
    }
}