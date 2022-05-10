# Min Cost Climbing Stairs

## Problem

You are given an integer array cost where cost[i] is the cost of `i`th step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

## Input

Integer array that contains a cost of each step.

## Example

- Example 1:

>Input: cost = [10,15,20]  
Output: 15  
Explanation: You will start at index 1.  
Pay 15 and climb two steps to reach the top.  
The total cost is 15.  

- Example 2:

>Input: cost = [1,100,1,1,1,100,1,1,100,1]  
Output: 6  
Explanation: You will start at index 0.  
Pay 1 and climb two steps to reach index 2.  
Pay 1 and climb two steps to reach index 4.  
Pay 1 and climb two steps to reach index 6.  
Pay 1 and climb one step to reach index 7.  
Pay 1 and climb two steps to reach index 9.  
Pay 1 and climb one step to reach the top.  
The total cost is 6.

## Constraints

- 2 <= cost.length <= 1000
- 0 <= cost[i] <= 999

## Output

The minimum cost to reach the top of the floor.

## Solution 1

Similar with a Fibonacci and climbing stairs problem, the minimum cost at the `n`th stair f(`n`) can be calculated by the below function.  

>f(n) = min(f(n-1) + cost[n-1], f(n-2) + cost[n-2])

And the top of the floor is located at the `cost.length`, so we can find the minimum cost at the top of the floor by the below function.

>f(top) = min(f(cost.length - 1) + cost[cost.length - 1], f(cost.length - 2) + cost[cost.length - 2])

And f(0) and f(1) are 0, then we can calculate the minimum cost from f(2) to f(top).

A time complexity is O(n) because we calculate the minimum cost at the nth step from 2 to the top of the floor.  
A space complexity is O(1) because we don't save anything in a memory.

- Time complexity: O(n)
- Space complexity: O(1)
