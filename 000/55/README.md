# Jump Game

## Problem

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

## Input

Integer array that contains the maximum jump length at the position.

## Example

- Example 1:

>Input: nums = [2,3,1,1,4]  
Output: true  
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.  

- Example 2:

>Input: nums = [3,2,1,0,4]  
Output: false  
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.  

## Constraints

- 1 <= nums.length <= 10^4
- 0 <= nums[i] <= 10^5

## Output

True if you can reach at the last index

## Solution 1

Each position describes the maximum jump length, and it means if `i`th index is `a`, you can go to anywhere from `i` to `i + a`.  
So, we can store the farthest position we can reach and traverse the given array to there.  
And if we reach the last index of the given array, a return is true, and if we reach the farthest position before reach the last index, a return is false.  

A time complexity is O(n) because we need to traverse the whole array at least once.  
A space complexity is O(1) because we store only the farthest position.

- Time complexity: O(n)
- Space complexity: O(1)

### Tip

Using Math.max() spend a less memory than comparing two integer by if statement.