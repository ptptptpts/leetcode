class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] moneyArray = new int[] {nums[0], nums[1], nums[0] + nums[2], 0};
        int cursor = 2;

        for (int i = 3; i < nums.length; i++) {
            cursor = (cursor + 1) & 0b11;
            int ppreviousMoney = moneyArray[(cursor + 2) & 0b11];
            int pppreviousMoney = moneyArray[(cursor + 1) & 0b11];
            moneyArray[cursor] = Math.max(ppreviousMoney, pppreviousMoney) + nums[i];
        }

        int lastCursor = (cursor + 3) & 0b11;
        return Math.max(moneyArray[cursor], moneyArray[lastCursor]);
    }
}
