# House Robber

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Input

Integer array that contains amount of money statshed in each house.

## Example

- Example 1:

>Input: nums = [1,2,3,1]  
Output: 4  
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).  
Total amount you can rob = 1 + 3 = 4.  

- Example 2:

>Input: nums = [2,7,9,3,1]  
Output: 12  
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).  
Total amount you can rob = 2 + 9 + 1 = 12.  

## Constraints

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 400

## Output

The maximum amount of money that you can rob tonight.

## Solution 1

At the `n`th house, a robber can be moved from `n-2`th house or `n-3`th house. So, the maximum amount of money at the `n`th house f(n) can be calculated by the below function.

>f(n) = max(f(n-2), f(n-3)) + cost(n)

And, f(0) is cost(0), f(1) is cost(1), and f(2) is cost(0) + cost(2) because the only scenario can move to 2nd house is moving from 0th house.

When a robber finish to rob all the house do as best, a robber will be in `n`th house or `n-1`th house because he can't rob the `n`th house if we rob the `n-1`th house. Therefore, we can find the maximum amount of money from the given array by the below function.

>Maximum about of money = max(f(n-1), f(n-2))  
(`n` is a size of array)

A time complexity is O(n) because we need to calculate the maximum amount of money at each house from start to the end.  
A space complexity is O(1) because we will save the maximum amount of money at the last 3 houses.

- Time complexity: O(n)
- Space complexity: O(1)
