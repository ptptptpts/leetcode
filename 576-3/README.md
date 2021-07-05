# Out of Boundary Paths

## Problem

There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 10^9 + 7.

## Input

Integer m, n that describe a grid.  
Integer maxMove that describes the maximum move count of the ball.  
Integer startRow, startColumn that describe a start position of the ball.

## Example

Example 1:

Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0  
Output: 6

Example 2:

Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1  
Output: 12

## Constraints

- 1 <= m, n <= 50
- 0 <= maxMove <= 50
- 0 <= startRow <= m
- 0 <= startColumn <= n

## Output

A number of paths to move the ball out of the grid boundary.

## Solution 1

On each next round, a number of paths to move the ball in this cell is sum of adjust cells.  
So, we can calculate a number of paths on each cell at each round from the previous round.
In additional, we need to calculate a number of paths to move the ball out of the grid boundary.

About Time complexity, it is O(mnM) because we need to calculate all the number of paths on m * n grid at M round.

About Space complexity, it is O(mn) because we need to save all the number of paths on m * n grid.

- Time complexity: O(mnM)
- Space complexity: O(mn)
