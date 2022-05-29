# Combination Sum IV

## Problem

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

## Input

Integer array that contains distinct integers, and a target integer.

## Example

- Example 1:

>Input: nums = [1,2,3], target = 4  
Output: 7  
Explanation:  
The possible combination ways are:  
(1, 1, 1, 1)  
(1, 1, 2)  
(1, 2, 1)  
(1, 3)  
(2, 1, 1)  
(2, 2)  
(3, 1)  
Note that different sequences are counted as different combinations.

- Example 2:

>Input: nums = [9], target = 3  
Output: 0

## Constraints

- 1 <= nums.length <= 200
- 1 <= nums[i] <= 1000
- All the elements of nums are unique.
- 1 <= target <= 1000

## Output

The number of possible combinations that add up to target.

## Solution 1

This problem is same with the problem that counts a number of cases to climb stairs. This problem has an order of each combinations, so a number of combinations on each integer can be found a sum of the previous combinations that can be made with the given coins. For example, if we want to find a number of combinations `c(n)` at the integer `n` with the coins `[1, 2, 4]`, it can be found by `c(n) = c(n-1) + c(n-2) + c(n-4)`.

A target integer is `n`, and a size of nums is `m`.  
A time complexity is O(n * m), because we need to find a number of combinations on each integer with all nums.  
A space complexity is O(n), because we need to save a number of combinations until the target.

- Time complexity: O(n * m)
- Space complexity: O(n)
