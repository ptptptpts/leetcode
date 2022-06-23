# Rotting Oranges

## Problem

You are given an m x n grid where each cell can have one of three values:

- 0 representing an empty cell,  
- 1 representing a fresh orange, or  
- 2 representing a rotten orange.  

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

## Input

Two-dimensional integer array that describe a position of oranges

## Example

- Example 1:

>Input: grid = [[2,1,1],[1,1,0],[0,1,1]]  
Output: 4

- Example 2:

>Input: grid = [[2,1,1],[0,1,1],[1,0,1]]  
Output: -1  
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

- Example 3:

>Input: grid = [[0,2]]  
Output: 0  
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

## Constraints

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

## Output

The minimum number of minutes that has no fresh orange, and -1 if it is impossible.

## Solution 1

We can use two stack or queue to find a new rotting oranges by saving
the last rotten oranges in the previous day. Because if some rotten
orange make all adjacent oranges to a rotten one, it does not have any
fresh orange nearby. So, we don't need to care about the rotten oranges
that already make adjacent oranges to rot.

First, we need to build an initial stack by finding all the rotten
oranges from the map. In this time, we need to count all the fresh
oranges in the map. After then, pop a rotten orange from the stack and
make adjacent oranges to rot and adding them to the stack for a next
minute. If an adjacent orange is a fresh one, we need to decrease a
number of fresh orange to find all the oranges are rotten or not. On
each day, we need to check a number of remained fresh oranges first, and
move to check a next stack if fresh oranges remains. And, if a next stack
is empty but fresh oranges remains in the map, we can assume it is
impossible to make all the fresh oranges to rot.

A time complexity is O(n * m), because each rotten orange can move one
cell on each minute. So, The maximum number of minutes that we can
return depends on a size of the map.  
A space complexity is O(n * m), because the maximum number of rotten
oranges that we can push the stack is not higher than a size of the map.

- Time complexity: O(n * m)
- Space complexity: O(n * m)
