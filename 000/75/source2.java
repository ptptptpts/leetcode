class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[]{0,0,0};
        for (int num : nums) {
            counter[num] += 1;
        }
        for (int cursor = 0; cursor < counter[0]; cursor++) {
            nums[cursor] = 0;
        }
        for (int cursor = counter[0]; cursor < (counter[0] + counter[1]); cursor++) {
            nums[cursor] = 1;
        }
        for (int cursor = counter[0] + counter[1]; cursor < nums.length; cursor++) {
            nums[cursor] = 2;
        }
    }
}
