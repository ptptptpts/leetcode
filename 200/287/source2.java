class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;

        for (int cursor = 0; cursor < nums.length; cursor++) {
            int nextCellId = Math.abs(nums[cursor]);
            if (nums[nextCellId] > 0) {
                nums[nextCellId] *= -1;
            } else {
                duplicate = nextCellId;
                break;
            }
        }

        for (int cursor = 0; cursor < nums.length; cursor++) {
            nums[cursor] = Math.abs(nums[cursor]);
        }

        return duplicate;
    }
}
