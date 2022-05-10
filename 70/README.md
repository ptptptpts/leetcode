# Climbing Stairs

## Problem

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## Input

Height of a staircase `n`

## Example

- Example 1:

>Input: n = 2  
Output: 2  
Explanation: There are two ways to climb to the top.  
>
>1. 1 step + 1 step  
>2. 2 steps  

- Example 2:

>Input: n = 3  
Output: 3  
Explanation: There are three ways to climb to the top.  
>
>1. 1 step + 1 step + 1 step  
>2. 1 step + 2 steps  
>3. 2 steps + 1 step  

## Constraints

- 1 <= n <= 45

## Output

Number of ways to climb to the top of a staircase.

## Solution 1

Each time you can climb 1 or 2 steps, so you can move to the `n`th staircase from the `n-1`th staircase and `n-2`th staircase. It can be described by the below function.

>f(n) = f(n - 1) + f(n - 2)

And, we can assume `f(0) = 1` and `f(1) = 1` to match `f(2)` as `f(2) = f(1) + f(0) = 2`. So, at the given numbe n, we can calculate an output by calculating from f(2) to f(n).  

A time complexity is O(n) because we calculate f(n) by finding from f(1) to f(n).  
A space complexity is O(1) because we don't save anything in a memory.

- Time complexity: O(n)
- Space complexity: O(1)
