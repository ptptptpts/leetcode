# Single Number

## Problem

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

## Input

Integer array that contains the elements twice except for one.

## Example

- Example 1:

>Input: nums = [2,2,1]  
Output: 1  

- Example 2:

>Input: nums = [4,1,2,1,2]  
Output: 4  

- Example 3:

>Input: nums = [1]  
Output: 1

## Constraints

- 1 <= nums.length <= 3 * 10^4
- -3 * 10^4 <= nums[i] <= 3 * 10^4
- Each element in the array appears twice except for one element which appears only once.

## Output

The element appears once in the array.

## Solution 1

We can use a hashset to find the elements appear twice, but it uses a O(n) extra space.
So, we need to find another way to find the single element.

First, the size of the given array is (2n+1) because the every element appears twice 
except for one. It means a number of bits in the every element appears twice is a
multiple of two. So, we can remove all the bits in the elements appears twice by `^`
operation. At the element that appears only once in the array will remain as a result
because all the bits that appear twice will be removed due to `^` operation.  

A time complexity is O(n) because we traverse the array only once.  
A space complexity is O(1) because we save only a integer that calculate `^` operation.

- Time complexity: O(n)
- Space complexity: O(1)
