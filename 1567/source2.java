class Solution {
    public int getMaxLen(int[] nums) {
        int longestPositive = 0;

        int positveStreek = 0;
        int negativeStreek = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                positveStreek = 0;
                negativeStreek = 0;
            } else {
                if (nums[i] > 0) {
                    positveStreek += 1;
                    if (negativeStreek > 0) {
                        negativeStreek += 1;
                    }
                } else {
                    int temp = negativeStreek;
                    negativeStreek = positveStreek + 1;
                    if (temp > 0) {
                        positveStreek = temp + 1;
                    } else {
                        positveStreek = 0;
                    }
                }

                longestPositive = Math.max(longestPositive, positveStreek);
            }
        }

        return longestPositive;
    }
}
