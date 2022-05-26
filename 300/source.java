class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] longests = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            longests[i] = 0;
        }

        int totalLongest = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentLongest = 0;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (longests[j] > currentLongest) {
                        currentLongest = longests[j];
                    }
                }
            }

            longests[i] = currentLongest + 1;
            if (longests[i] > totalLongest) {
                totalLongest = longests[i];
            }
        }

        return totalLongest;
    }
}
