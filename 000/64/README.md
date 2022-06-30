# Minimum Path Sum

## Problem

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

## Input

Two dimensions of integer array that contains only a positive value or 0.

## Example

- Example 1:

>Input: grid = [[1,3,1],[1,5,1],[4,2,1]]  
Output: 7  
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

- Example 2:

>Input: grid = [[1,2,3],[4,5,6]]  
Output: 12

## Constraints

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 200
- 0 <= grid[i][j] <= 100

## Output

The minimum path sum from top-left to bottom-right corner.

## Solution 1

This is similar with the other array traverse problems. Because we can move to down or right on any point, so we can traverse an array to downward and rightward. And, on each position, we can select a smaller one between a left and upper point to find the minimum path of a current point.  
To find the minimum path at each position, we need to save the previous histories. We basically save the minimum path sum of entire array, but if we already have the minimum path sum of `i`th row, we don't need the previous history to `i-1`th row. So, we can save only the previous and current row to find the minimum path sum.

A time complexity is O(n*m) because we need to traverse entire given array.  
A space complexity is O(m) because we make a logic to traverse the array from column first. If we select a shorter one and store a current cost in there, a space compelxity is O(min(n, m)).

- Time complexity: O(n*m)
- Space complexity: O(m)
