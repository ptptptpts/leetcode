# Climbing Stairs

## Problem

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## Input

N, height of a staircase.

## Constraints

- 1 <= n <= 45

## Output

Number of ways to climb to the top.

## Solution

On n-th stair, we can move to n+1 th stair or n+2 th stair.  
In opposite side, we can move to n-th star from n-1 th stair or n-2 th stair.  
With this assume, we can describe a number of ways to climb to n th stair f(n) by this function.

f(n) = f(n-1) + f(n-2)  
f(1) = 1
f(2) = 2

Therefore, time complexity is O(n) because we need to calculate from f(1) to f(n).

About space complexity, we don't need to save f(n-3) for calculating f(n).
So, it is enough to save only three previous histories for calculating f(n).
Therefore, space complexity is O(1).

- Time complexity: O(n)
- Space complexity: O(1)
