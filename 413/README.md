# Arithmetic Slices

## Problem

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

- For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [1,2,3,4]  
Output: 3  
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

- Example 2:

>Input: nums = [1]  
Output: 0

## Constraints

- 1 <= nums.length <= 5000
- -1000 <= nums[i] <= 1000

## Output

Number of arithmetic arrays that can be made by a subarray of the given nums.

## Solution 1

If we find an arithmatic array at the `n`th position, a difference between `n`th and `n-1`th integer is same with a difference between `n-1`th integer and `n-2`th integer. Even if we can make an arithmatic array from `n-3` and more than before, it is same because an arithmatic array has a same difference on each consecutive elements.  
Then, we need to find a length of arithmetic array at the current element, and add a number of subarrays as a length of arithmetic array because a current element create a new subarray with the previous elements.

A time complexity is O(n) because we need to find a length of arithmatic array on each element.  
A space complexity is O(1) because we save a length of arithmatic array only at a current element.

- Time complexity: O(n)
- Space complexity: O(1)
