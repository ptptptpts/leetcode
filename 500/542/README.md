# 01 Matrix

## Problem

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

## Input

2 dimension integer array that contains only 0 and 1.

## Example

Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]  
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]  
Output: [[0,0,0],[0,1,0],[1,2,1]]

## Constraints

- m == mat.length
- n == mat[i].length
- 1 <= m, n <= 10^4
- 1 <= m * n <= 10^4
- mat[i][j] is either 0 or 1.
- There is at least one 0 in mat.

## Output

2 dimension integer array that contains the distance of the nearest 0.

## Solution 1

We can traverse the array by BFS starting from all 0 point. On each point, we mark the current point as visited and put the adjacent points to queue.

The Time complexity is O(m*n) because we traverse the array only once.

The Space complexity is O(m*n) because we save all the points at least once in queue and create anothe array for saving visited and return value.

- Time complexity: O(m*n)
- Space complexity: O(m*n)

## Solution 2

If we traverse the array from left top to right bottom, we couldn't find the nearest 0 from right and bottom.
On the other way, we couldn't find the nearest 0 from left and top if we traverse the array from right bottom to left top.
However, if we traverse the array twice and select the minimum distance of the nearest 0 between left-top and right-bottom, we can find a distance from the nearest 0.

The Time complexity is O(m*n), because we traverse the array twice from left top to right bottom and from right bottom to left top.

The Space complexity is O(m*n), because we save a distance of the nearest 0 in another array.

- Time complexity: O(m*n)
- Space complexity: O(m*n)
