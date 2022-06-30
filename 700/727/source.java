class Solution {
    public int removeDuplicates(int[] nums) {
        int cursor = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[cursor] = nums[i];
                cursor++;
            }
        }

        return cursor;
    }
}