import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Input: Arrays of integer and target number
        // Output: Integer array with two numbers. This two number points a position in the integer array. The sum of two numbers is the target number.
        
        // Input has exactly one solution
        // May not use the same element twice

        // What is the size of integer array? 2 <= n <= 10^4
        // What is a range of integer array? -10^9 <= n <= 10^9
        // What is a range of target? -10^9 <= n <= 10^9

        // Because a range of integer array is very large, it is impossible to mark integers in array to find the matched one as O(1)
        // But, we can still use a HashMap to find the matched integer in a constant cost O(1)
        // Becauase the same integer can be used as the same purpose, we can overwrite the previous position to the new one.

        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int[] result = new int[] {-1, -1};

        for (int pos = 0; pos < nums.length; pos++) {
            int currentNum = nums[pos];
            int matchedNum = target - currentNum;

            if (numsMap.containsKey(matchedNum)) {
                result[0] = numsMap.get(matchedNum);
                result[1] = pos;
                break;
            }

            numsMap.put(currentNum, pos);
        }
        
        return result;
    }
}