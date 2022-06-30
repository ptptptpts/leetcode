# Binary Search

## Problem

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

## Input

Integer array sorted in ascending order, and a target integer.

## Example

- Example 1:

>Input: nums = [-1,0,3,5,9,12], target = 9  
Output: 4  
Explanation: 9 exists in nums and its index is 4

- Example 2:

>Input: nums = [-1,0,3,5,9,12], target = 2  
Output: -1  
Explanation: 2 does not exist in nums so return -1

## Constraints

- 1 <= nums.length <= 10^4
- -10^4 < nums[i], target < 10^4
- All the integers in nums are unique.
- nums is sorted in ascending order.

## Output

Return index if a target exist, and -1 if a target does not exist

## Solution 1

If the given array is sorted, we can assume this array as a binary tree.
Then, if a target is in `[start, end)` of the array, a root of a current array is in `(start + end) / 2`.
And, if a target is smaller than a root, a target will be in `[start, (start + end) / 2)` range.
Also, if a target is larger than a root, a target will be in `[(start + end) / 2 + 1, end)`.
Next, if a start is same or larger than end, a target does not exist.

A time complexity is O(log n) because it searches the given array as a binary search.  
A space complexity is O(1) because we save only a start and end of current window.

- Time complexity: O(log n)
- Space complexity: O(1)
