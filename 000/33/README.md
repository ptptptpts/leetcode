# Search in Rotated Sorted Array

## Problem

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

## Input

Integer array and a target number

## Example

- Example 1:

>Input: nums = [4,5,6,7,0,1,2], target = 0  
Output: 4

- Example 2:

>Input: nums = [4,5,6,7,0,1,2], target = 3  
Output: -1

- Example 3:

>Input: nums = [1], target = 0  
Output: -1

## Constraints

- 1 <= nums.length <= 5000
- -10^4 <= nums[i] <= 10^4
- All values of nums are unique.
- nums is an ascending array that is possibly rotated.
- -10^4 <= target <= 10^4

## Output

Position of a target number in the given array 

## Solution 1

Let's find a target number by binary search from the given array.  

If a middle of an array is smaller than a target number, normally a target number is in
a right side of the array. But, in this problem, the given array can be rotated, so a
left side of the array can have a target number if it is rotated. So, we need to compare
a last element of a right side to find a target number is in a right side or not. If the
last element of a right side still smaller than a target number, the given array is
rotated and the target number is in a left side of the array.

If a middle of an array is larger than a target number, we can apply the same rule. If
the first element of a left side is still larger than a target number, the array is
rotated and the target number is in a right side of the given array.

We can repeat this until we find a target number or a size of window in 0. If we find
a target number, we can return a position of it. If a size of window is 0, we can return
-1.

A time complexity is O(log n) because we use a binary search to find a target number.  
A space complexity is O(1) because we save only a size of window.

- Time complexity: O()
- Space complexity: O(1)
