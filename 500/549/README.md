# Single Number

## Problem

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

## Input

Integer array

## Constraints

- 1 <= nums.length <= 3 * 10^4
- -3 * 10^4 <= nums[i] <= 3 * 10^4
- Each element in the array appears twice except for one element which appears only once.

## Output

Return the elementn which appears only once.

## Solution 1

Sort the input array and compare each odd item with the next even one.  
If 2n-1 th item is different with the 2n th item, it is the single one.

- Time complexity: O(nlogn)
- Space complexity: O(1)

## Solution 2

If xor some number twice, it does not have any effect on the original number like this.

A xor B xor B = A

So, executing xor on the all the elements in the input array, only the single element will be remained.

- Time complexity: O(n)
- Space complexity: O(1)
