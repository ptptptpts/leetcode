# Missing Number

## Problem

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

## Input

Integer array that contains a unique number in the range [0, n]

## Example

- Example 1:

>Input: nums = [3,0,1]  
Output: 2  
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

- Example 2:

>Input: nums = [0,1]  
Output: 2  
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

- Example 3:

>Input: nums = [9,6,4,2,3,5,7,0,1]  
Output: 8  
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

## Constraints

- n == nums.length
- 1 <= n <= 10^4
- 0 <= nums[i] <= n
- All the numbers of nums are unique.

## Output

A missing number in the array from a range [0, n]

## Solution 1

The given array does not contain a duplicate number, so we can find the missing number by a difference between a sum of array and a sum of integer from 1 to n.  
Simply, if `i` is missing from the given array, a sum of array `sum(array)` will be the below function.  

>sum(array) = sum(n) - i

A time complexity is O(n) because we need to traverse the given array to find a sum of array.  
A space complexity is O(1) because we save only a sum of array.

- Time complexity: O(n)
- Space complexity: O(1)
