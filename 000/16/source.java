class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] nearestSums = new int[4001];
        int tempSum = nums[0] + nums[1];
        for (int i = 0; i < 4001; i++) {
            nearestSums[i] = tempSum;
        }

        int closest = nums[0] + nums[1] + nums[2];
        for (int pos = 2; pos < nums.length; pos++) {
            int ideal = target - nums[pos];
            ideal = Math.min(ideal, 2000);
            ideal = Math.max(-2000, ideal);

            int currentClosest = nearestSums[ideal + 2000] + nums[pos];
            if (Math.abs(target - currentClosest) < Math.abs(target - closest)) {
                closest = currentClosest;
            }

            for (int j = 0; j < pos; j++) {
                int sum = nums[j] + nums[pos];
                int sumPos = sum + 2000;
                nearestSums[sumPos] = sum;

                int diff = 1;
                while (Math.abs(nearestSums[sumPos + diff] - (sum + diff)) > diff) {
                    nearestSums[sumPos + diff] = sum;
                    diff++;
                    if ((sumPos + diff) > 4000) {
                        break;
                    }
                }
                diff = 1;
                while (Math.abs(nearestSums[sumPos - diff] - (sum - diff)) > diff) {
                    nearestSums[sumPos - diff] = sum;
                    diff++;
                    if ((sumPos - diff) < 0) {
                        break;
                    }
                }
            }
        }
        return closest;
    }
}