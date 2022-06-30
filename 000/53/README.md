# Maximum Subarray

## Problem

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [-2,1,-3,4,-1,2,1,-5,4]  
Output: 6  
Explanation: [4,-1,2,1] has the largest sum = 6.  

- Example 2:

>Input: nums = [1]  
Output: 1  

- Example 3:

>Input: nums = [5,4,-1,7,8]  
Output: 23

## Constraints

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4

## Output

The largest sum of a subarray

## Solution 1

If we has a local maximum sum of subarray at the previous item and it is larger than 0, a local maximum sum at the current item is a sum of a current integer with the previous local maximum sum. If it is smaller than 0, we don't need to care about them because it is a negative. In each item, we can compare a local maximum sum with a entire maximum sum and save a local maximum sum if it is larger than a entire maximum sum.

A time complexity is O(n) because we need to traverse the given array at least once.  
A space complexity is O(1) because we save only the maximum and local maximum sum of a subarray.

- Time complexity: O(n)
- Space complexity: O(1)
