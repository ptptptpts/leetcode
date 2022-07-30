# Move Zeroes

## Problem

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [0,1,0,3,12]  
Output: [1,3,12,0,0]

- Example 2:

>Input: nums = [0]  
Output: [0]

## Constraints

- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1

## Output

Integer array that move all the zeros to the end of the array

## Solution 1

To find and move zero and non-zero integers from the array, we can use two cursors to
traverse the array and move non-zero integers to each position. First, we'll traverse
the array with the first cursor. And, if the first cursor points a non-zero integer,
we'll move it to the second cursor and move the second cursor to the next one. And, if
the first cursor points a zero, we don't do anything for that. In each loop, we'll move
the first cursor to the next one until we find the end of the array. When we find the
end of the array at the first cursor, we'll fill the all the remained positions from the
second cursor to a zero.

A time complexity is O(n) because we traverse the array only once.  
A space complexity is O(1) because we use only two cursors to move zeros.

- Time complexity: O(n)
- Space complexity: O(1)
