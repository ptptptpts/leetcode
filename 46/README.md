# Permutations

## Problem

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

## Input

Integer array with distinct integers

## Example

- Example 1:

>Input: nums = [1,2,3]  
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

- Example 2:

>Input: nums = [0,1]  
Output: [[0,1],[1,0]]

- Example 3:

>Input: nums = [1]  
Output: [[1]]

## Constraints

- 1 <= nums.length <= 6
- -10 <= nums[i] <= 10
- All the integers of nums are unique.

## Output

Array of integer array that contains all the possible permutations.

## Solution 1

We can find all the permutations by searching all the cases from the given array.
But because we can't visit the already used value again, so we need to check each value is visited or not.
To find the visited value, we can use a boolean array to mark it is visited or not.

To make a permutation, we will call the method to visit any integer in the given array
with a boolean array that contains information about each item is visited or not and
an array that contains the visited values. And if a position to put a value to array is
an end of the array, we can assume the array is full and put it to the return array.

A time complexity is O(nums.length!) because a number of permutations is a factorial.  
A space complexity is also O(nums.lenght!) because we need to save all the permutations in the return array.

- Time complexity: O(nums.length!)
- Space complexity: O(nums.length!)
