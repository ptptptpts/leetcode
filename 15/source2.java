class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        for (int pos = 0; pos < nums.length - 2; pos++) {
            int lcursor = pos + 1;
            int rcursor = nums.length - 1;

            if ((pos > 0) && (nums[pos] == nums[pos - 1])) {
                continue;
            }
            while (lcursor < rcursor) {
                int sum = nums[pos] + nums[lcursor] + nums[rcursor];

                if (sum == 0) {
                    ret.add(Arrays.asList(nums[pos], nums[lcursor], nums[rcursor]));
                    while ((lcursor < rcursor) && (nums[lcursor] == nums[lcursor + 1])) {
                        lcursor += 1;
                    }
                    while ((lcursor < rcursor) && (nums[rcursor] == nums[rcursor - 1])) {
                        rcursor -= 1;
                    }
                    lcursor += 1;
                    rcursor -= 1;

                } else if (sum < 0) {
                    lcursor += 1;
                } else {
                    rcursor -= 1;
                }
            }
        }

        return ret;
    }
}
