class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean isIncreasing = true;
        boolean canRemoveOneElement = true;

        if ((nums != null) && (nums.length > 1)) {
            if (nums[0] >= nums[1]) {
                canRemoveOneElement = false;
                nums[0] = nums[1];
            }
            for (int cursor = 1; cursor < nums.length - 1; cursor++) {
                if (nums[cursor] >= nums[cursor + 1]) {
                    if (canRemoveOneElement) {
                        canRemoveOneElement = false;
                        if (nums[cursor - 1] < nums[cursor + 1]) {
                            nums[cursor] = nums[cursor + 1];
                        } else {
                            nums[cursor + 1] = nums[cursor];
                        }
                    } else {
                        isIncreasing = false;
                        break;
                    }
                }
            }
        }

        return isIncreasing;
    }
}
