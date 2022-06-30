class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        
        Arrays.sort(nums);

        ret = nums[nums.length - 1];
        for (int i=0; i<nums.length - 1; i += 2) {
            if (nums[i] != nums[i+1]) {
                ret = nums[i];
                break;
            }
        }

        return ret;
    }
}