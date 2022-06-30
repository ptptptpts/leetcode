class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        int[] moneyArray = new int[] {nums[0], nums[1], nums[0] + nums[2], 0};
        int cursor = 2;
        for (int i = 3; i < nums.length - 1; i++) {
            cursor = (cursor + 1) & 0b11;
            int pp = moneyArray[(cursor + 2) & 0b11];
            int ppp = moneyArray[(cursor + 1) & 0b11];
            moneyArray[cursor] = Math.max(pp, ppp) + nums[i];
        }
        int maxWithFirst = Math.max(moneyArray[cursor], 
            moneyArray[(cursor + 3) & 0b11]);

        moneyArray = new int[] {nums[1], nums[2], nums[1] + nums[3], 0};
        cursor = 2;
        for (int i = 4; i < nums.length; i++) {
            cursor = (cursor + 1) & 0b11;
            int pp = moneyArray[(cursor + 2) & 0b11];
            int ppp = moneyArray[(cursor + 1) & 0b11];
            moneyArray[cursor] = Math.max(pp, ppp) + nums[i];
        }
        int maxWithoutFirst = Math.max(moneyArray[cursor], 
            moneyArray[(cursor + 3) & 0b11]);

        return Math.max(maxWithFirst, maxWithoutFirst);
    }
}
