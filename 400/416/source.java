import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int totalSum = Arrays.stream(nums).sum();
        if ((totalSum & 0b1) == 1) {
            return false;
        }

        int subsetSum = totalSum >> 1;
        boolean[] previousHistory = new boolean[subsetSum + 1];
        boolean[] currentHistory = new boolean[subsetSum + 1];
        for (int i = 0; i <= subsetSum; i++) {
            previousHistory[i] = false;
            currentHistory[i] = false;
        }
        for (int num : nums) {
            if (num > subsetSum) {
                break;
            }

            System.arraycopy(previousHistory, 0, currentHistory, 0, num);
            currentHistory[num] = true;
            for (int cursor = num + 1; cursor <= subsetSum; cursor++) {
                currentHistory[cursor] = previousHistory[cursor - num] | previousHistory[cursor];
            }

            boolean[] temp = previousHistory;
            previousHistory = currentHistory;
            currentHistory = temp;

            if (previousHistory[subsetSum]) {
                break;
            }
        }
        return previousHistory[subsetSum];
    }
}
