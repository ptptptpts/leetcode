class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] counts = new int[target + 1];

        counts[0] = 1;
        for (int pos = 1; pos <= target; pos++) {
            int currentCounts = 0;
            for (int num : nums) {
                if (num <= pos) {
                    currentCounts += counts[pos - num];
                }
            }
            counts[pos] = currentCounts;
        }

        return counts[target];
    }
}
