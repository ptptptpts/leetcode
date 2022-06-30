class Solution {
    public int missingNumber(int[] nums) {
        int realSumOfArray = (nums.length + 1) * (nums.length / 2);
        if ((nums.length & 0b1) == 1) {
            realSumOfArray += nums.length / 2 + 1;
        }
        for (int num : nums) {
            realSumOfArray -= num;
        }
        return realSumOfArray;
    }
}