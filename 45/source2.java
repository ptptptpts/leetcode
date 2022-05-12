class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int previousMaxJump = 0;
        int currentMaxJump = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > previousMaxJump) {
                jumpCount++;
                previousMaxJump = currentMaxJump;
            }
            
            currentMaxJump = Math.max(currentMaxJump, i + nums[i]);
        }

        return jumpCount;
    }
}