# Wiggle Subsequence

## Problem

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

- For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
- In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.

A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [1,7,4,9,2,5]  
Output: 6  
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).

- Example 2:

>Input: nums = [1,17,5,10,13,15,10,5,16,8]  
Output: 7  
Explanation: There are several subsequences that achieve this length.  
One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).

- Example 3:

>Input: nums = [1,2,3,4,5,6,7,8,9]  
Output: 2

## Constraints

- 1 <= nums.length <= 1000
- 0 <= nums[i] <= 1000

## Output

The length of the longest wiggle subsequence can be made by the given array

## Solution 1

If we find some array is wiggle, it means each element is a positive or negative peek. Then, we can convert the problem to find a number of positive and negative peeks from the given array.  
However, we have one side case that the given array does not have any peek. For example, if the given array has the same number on each element, it has only one peek.  
To handle this case, we can save a status as increasing, decreasing, and flat at the first. The first element starts with a flat, and the next element updates it as increasing or decreasing if it is different with the first item. If we move to increasing or decreasing first, we don't need to return back to flat because we can assume the next flat as a contious increasing or decreasing.

A time complexity is O(n) because we traverse the given array and compare it with only the previous element.  
A space complexity is O(1) because we save only a current increasing status and a number of peeks.

- Time complexity: O(n)
- Space complexity: O(1)
