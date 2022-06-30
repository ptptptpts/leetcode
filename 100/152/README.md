# Maximum Product Subarray

## Problem

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [2,3,-2,4]  
Output: 6  
Explanation: [2,3] has the largest product 6.

- Example 2:

>Input: nums = [-2,0,-1]  
Output: 0  
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

## Constraints

- 1 <= nums.length <= 2 * 10^4
- -10 <= nums[i] <= 10
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

## Output

The maximum product of subarray that can be created by the given array.

## Solution 1

When we product two integers, absolute of a result always increase from two previous integers. And, this problem guarantee any product of subarray fits in a 32-bit integer. So, we can assume an absolute of a product always increase from before if nums[i] is not 0, and only its sign is changed as a sign of nums[i]. And, if some product is in a negative when we traverse forward, it can be a positive when we traverse backward.  
Then, we can find two maximum product from a forward and backward traversal, and can select a larger one as the maximum product.

A time complexity is O(n) because we need to traverse an array by forward and backward twice.  
A space complexity is O(1) because we save only the maximum product in forward and backward.

- Time complexity: O(n)
- Space complexity: O(1)
