# Jump Game II

## Problem

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

## Input

Integer array that contains the maximum jump length at that position.

## Example

- Example 1:

>Input: nums = [2,3,1,1,4]  
Output: 2  
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.  

- Example 2:

>Input: nums = [2,3,0,1,4]  
Output: 2

## Constraints

- 1 <= nums.length <= 104
- 0 <= nums[i] <= 1000

## Output

The minimum number of jumps to reach the last index.

## Solution 1

When we can jump from `i`th index to `j`th index, we can assume we will reach the `j+1`th index by jumping again from somewhere between `i` and `j`, because the given array in this problem always reach the last index. With this assume, we can divide this problem to find a number of the local maximums like this.

.|0|1|2|3|4
----|----|----|----|----|----|
Array|2|3|1|1|4
LocalMax|2|4|4|4|x

A time complexity is O(n) because we need to traverse the array at least once.  
A space complexity is O(1) because we save only a start of the local maximum and a number of local maximums.  

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

From the assuem in the solution 1, we can make more simple solution. From the solution 1, we assume we will jump again at the `j+1`th index. It means when we across the previous farthest index, a jump count is increased.  
With this solution the only thing we need to make for this problem is saving the last maximum position and increase a jump count when a current index `i` is larger than the last maximum position.

A time complexity and space complexity is same with the solution 1.

- Time complexity: O(n)
- Space complexity: O(1)
