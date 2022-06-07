# Contains Duplicate

## Problem

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

## Input

An integer array contains nums

## Example

- Example 1:

>Input: nums = [1,2,3,1]  
Output: true

- Example 2:

>Input: nums = [1,2,3,4]  
Output: false

- Example 3:

>Input: nums = [1,1,1,3,3,4,3,2,4,2]  
Output: true

## Constraints

- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9

## Output

True if any element appears at least twice

## Solution 1

Because a range of num is too wide, we can't count each integer in array.  
We can save them in a HashSet, and compare each integer is appeared previously from the HashSet.  
It uses additional memory to save the previous history, but it is better at time complexity because a cost to push or find some element to HashSet is ideally O(1).

A time complexity is O(n) because we need to find and put every element to HashSet.  
A space complexity is O(n) because we need to save every element to HashSet.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

In the other way, if the array is sorted, we can find each integer is duplicated or not by comparing it with the previous element.  
In this case, we don't need to use any additional memory to save the previous history, but use additional cost to sort the given array.
Ideally, if we can sort the given array with a heapsort or quicksort with a common cost, we can sort them in O(nlogn) cost.

A time complexity is O(nlogn) because we need to sort the given array, and the best cost of it is O(nlogn).  
A space complexity is O(1) because we don't save the previous history in this case.

- Time complexity: O(nlogn)
- Space complexity: O(1)
