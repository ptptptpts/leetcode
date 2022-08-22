# Squares of a Sorted Array

## Problem

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

## Input

An integer array sorted in non-decreasing order.

## Example

- Example 1:

>Input: nums = [-4,-1,0,3,10]  
Output: [0,1,9,16,100]  
Explanation: After squaring, the array becomes [16,1,0,9,100].  
After sorting, it becomes [0,1,9,16,100].

- Example 2:

>Input: nums = [-7,-3,2,3,11]  
Output: [4,9,9,49,121]

## Constraints

- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- nums is sorted in non-decreasing order.

## Output

An integer array of the squares of each number in the given array and sorted in non-decreasing order.

## Solution 1

The smallest square of integer is the smallest absolute value of the given array. And,
the given array is sorted in non-decreasing order, so we can find the smallest absolute
value from the first positive or negative value. From there, we can traverse the given
array by forward and backward with two cursors, and append the smaller absolute value to
the output array.

A time complexity is O(n) because we traverse the array twice, to find the smallest
absolute value and build the output array.  
A space complexity is O(n) because we need to make the output array.

- Time complexity: O(n)
- Space complexity: O(n)
