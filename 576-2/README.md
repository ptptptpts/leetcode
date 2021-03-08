# House Robber

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

## Input

Integer array with the amount of money of each house.

## Constraints

- 0 <= nums.length <= 100
- 0 <= nums[i] <= 400

## Output

The maximum amount of money can rob tonight.

## Solution 1

To move to n th house, we can move from n-2 th and the previous house.  
But, from the n-4 th house, it could not make the maximum profit because we can rob the n-2 th house before robbing n th house.  
So, we can assume the profit of n th house f(n) is sum of profit of n th house and a larger one between f(n-2) and f(n-3).

After find the maximum profit on each house, we can find the maximum profit of input array by comparing f(n) and f(n-1) because we already find the maximum profit between f(n-2) and f(n-3) when calculating f(n).

About time complexity, it is O(n) because we need to track the entire items in the given array.  
About space complexity, it is O(1) because we need to save only the last four maximum profits about f(n), f(n-1), f(n-2), and f(n-3).

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

From the Solution 1, it can be improved by always finding the best profit on f(n).
If all the f(n) always has the best profit on f(n), we don't need to compare between f(n-2) and f(n-3) when calculating f(n).

Let's starting from f(0), the maximum profit of f(0) is the profit at 0 th house p().
About f(1), the maximum profit of f(1) is the larger one between p(0) and p(1).
About f(2), the maximum profit of f(2) is the larger one between f(1) and (f(0) + p(2)), because we can rob 2-th house after robbing 0-th house.
About f(3), the maximum profit of f(3) is the larger one between f(2) and (f(1) + p(3)), and ongoing to n th house.

The time complexity and space complexity of this solution is same with the solution 1, but it is slightly faster than the solution 1 because it has less calculation than the solution 1.

## For Best Performance
