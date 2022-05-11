# House Robber II

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Input

Integer array that contains an amount of money stashed.

## Example

- Example 1:

>Input: nums = [2,3,2]  
Output: 3  
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.  

- Example 2:

Input: nums = [1,2,3,1]  
Output: 4  
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).  
Total amount you can rob = 1 + 3 = 4.  

- Example 3:

Input: nums = [1,2,3]  
Output: 3

## Constraints

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 1000

## Output

The maximum amount of money can be robbed.

## Solution 1

Similar with the 198th problem `House Robber`, we can calculate the maximum amount of money at the `n`th house by the below function.

>f(n) = Max(f(n-1), f(n-2)) + cost(n)

In this problem, the houses are located in a circle. So, if a robber visits the 1st house, he can't visit the last house. In opposite, if a robber does not visit the 1st house, he can visit the last house. Then, we can change this condition to solve two `House Robber` problems with a range `0` to `n-1` and `1` to `n`. And the maximum amount of money is a larger one between two solutions. We can describe it as the below function.

>CircularMax(0, n) = Max(LineMax(0, n-1), LineMax(1, n))  

A time complexity is O(n) because we just solve two `House Robber` problems and its time complexity is O(n).  
A space complexity is O(1) because we don't save anything for solving two `House Robber` problems and its space cost is O(1).

- Time complexity: O(n)
- Space complexity: O(1)
