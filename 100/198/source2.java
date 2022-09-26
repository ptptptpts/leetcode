class Solution {
    public int rob(int[] nums) {
        int[] maxProfits = new int[2];
        int[] nextMaxProfits = new int[2];
        maxProfits[0] = nums[0];
        maxProfits[1] = 0;

        for (int cursor = 1; cursor < nums.length; cursor++) {
            nextMaxProfits[0] = maxProfits[1] + nums[cursor];
            nextMaxProfits[1] = Math.max(maxProfits[0], maxProfits[1]);

            int[] temp = nextMaxProfits;
            nextMaxProfits = maxProfits;
            maxProfits = temp;
        }

        return Math.max(maxProfits[0], maxProfits[1]);
    }
}
