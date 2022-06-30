# Making A Large Island

## Problem

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

## Input

Two dimension integer array that contains only 0 or 1.

## Example

Example 1:  
Input: grid = [[1,0],[0,1]]  
Output: 3  
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.  

Example 2:  
Input: grid = [[1,1],[1,0]]  
Output: 4  
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

Example 3:  
Input: grid = [[1,1],[1,1]]  
Output: 4  
Explanation: Can't change any 0 to 1, only one island with area = 4.

## Constraints

- n == grid.length
- n == grid[i].length
- 1 <= n <= 500
- grid[i][j] is either 0 or 1.

## Output

The largest size of island after changing at most one 0 to be 1.

## Solution 1

To find the largest size of island after changin at most one 0 to be 1, we need to traverse array and find a sumf of a size of adjacent islands with the 0.

To find the size of each island, we can count all the connected '1' by dfs or bfs. However, because a size of each island does not change, we can save a size of each island first and use it when we find the adjacent island.

So, we can divide the problem by two steps. The first step is calculating a size of each island in array. And the second step is finding the largest size of each island when we change at most one 0 to be 1.

In the first step, we can save a size of island with an id of island in a HashMap or Array, and also save an id of island in the input array. In this step, we should assign an id of island from 2 because 1 is already assigned to describe an island.

In the second step, we need to find the adjacent island in each 0 item. However, the one island can adjacent two or more side on the '0'. So, we need to skip the island we already count.

The Time complexity is O(n^2), because we need to traverse all the array at least once to find the size of each island.

The Space Complexity is O(n^2), because we need to save a size of each island and the maximum number of islands depends on a size of array.

- Time complexity: O(n^2)
- Space complexity: O(n^2)
