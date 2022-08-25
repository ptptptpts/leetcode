# Largest Number

## Problem

Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [10,2]  
Output: "210"

- Example 2:

>Input: nums = [3,30,34,5,9]  
Output: "9534330"

## Constraints

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 10^9

## Output

The largest integer in String format that can make by appending integers in the given array.

## Solution 1

We can make the largest output by appending the integer starting with the largest value
`9` and finishing with the largest value `9` as it can. So, we need to order the given
integer array by the following order.

1) If the most significant integer of A is higher than B, A is higher than B.
2) If the most significant integers are same, compare the next integer.
3) If the integer A is ended first, the integer A is higher than B.

A time complexity is O(nlogn) because we need to sort the array.    
A space complexity is O(n) because a size of result depends on a number of integers in
the given array.

- Time complexity: O(nlogn)
- Space complexity: O(1)
