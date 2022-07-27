# 3Sum Closest

## Problem

Given an integer array `nums` of length n and an integer `target`, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

## Input

Integer array and a integer `target`

## Example

- Example 1:

>Input: nums = [-1,2,1,-4], target = 1  
Output: 2  
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

- Example 2:

>Input: nums = [0,0,0], target = 1  
Output: 0

## Constraints

- 3 <= nums.length <= 1000
- -1000 <= nums[i] <= 1000
- -10^4 <= target <= 10^4

## Output

The sum of the three integers that can make by three integers in the given `nums` and closest to target

## Solution 1

If we select two integers from the given array, the last one element is defined to the
integer we can make the closest sum with the given two integers. So, basically we can
find the solution in O(n^2) time complexity if we can find the last integer in a
constant time.

A range of the integers in the given array is small. So, we can save which integer exist
or not in the array in the range. We can assume the 0 as arr[1000], -1000 as arr[0], and
1000 as arr[2000]. Next, we can save the nearest integer on each element in the array to
find it on the constant time. To build this array, we can sort the given array once, and
build the nearest integer array with it.

After we build the nearest integer array, we can select two integers from the list and
find the nearest integer from the nearest array.

A time complexity is O(n^2) because we need to select two integer from the array.  
A space complexity is O(m) because we need to build the nearest array from a range of
integers of nums[i].

- Time complexity: O(n^2)
- Space complexity: O(1)
