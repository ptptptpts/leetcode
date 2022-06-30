class Solution {
    public boolean canJump(int[] nums) {
        boolean ret = true;
        int maxPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) {
                ret = false;
                break;
            } else {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (maxPosition >= nums.length) {
                    break;
                }
            }
        }

        return ret;
    }
}
