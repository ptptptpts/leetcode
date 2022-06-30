# Two Sum

## Problem

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Input

An array of integers nums that contains numbers. This array can contains duplicate numbers.  
An integer target that can be made by adding of the two numbers in the array.

## Example

Example 1:  
Input: nums = [2,7,11,15], target = 9  
Output: [0,1]  
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:  
Input: nums = [3,2,4], target = 6  
Output: [1,2]  

Example 3:  
Input: nums = [3,3], target = 6  
Output: [0,1]  

## Constraints

- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
- Only one valid answer exists.

## Output

An array of integers that contains a position of two numbers that can make up to target.

## Solution 1

First, we can save all the numbers in the array in HashMap and find the number that can make the target from it. With this logic, we can find the number by O(1) cost and the time complexity of this solution is O(n).

Next, let's assume we receive the number one by one. In this case, we need to care about the pair with the current number because all the pairs made by the previous numbers could not make a target number. So, we can find the target while adding a current number to the HashMap and can find the result by traverse the nums only once.

The Time complexity is O(n) because we need to traverse the nums at least once.

The Space complexity is O(n) because we save all the numbers in HashMap.

- Time complexity: O(n)
- Space complexity: O(n)
