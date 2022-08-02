class Solution {
    public int missingNumber(int[] nums) {
        // Input: integer array that contains a number in [0, n]
        // Output: A missing number in the given integer array

        // Size of the array? 1 <= n <= 10^4
        // All the numbers in the array are unique

        // Simply, if the array contains all the numbers in [0, n], a sum of all the integers is
        // (n + 1) * (n / 2). The array has one missing number, so a sum of all the integers in the
        // array will be smaller than an ideal sum as the missing value. Therefore, we can find the
        // missing number by find a difference between an ideal sum and a sum of the given array.

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int idealSum = (nums.length + 1) * (nums.length / 2);
        if ((nums.length & 1) == 1) {
            idealSum += nums.length / 2 + 1;
        }

        return idealSum - sum;
    }
}