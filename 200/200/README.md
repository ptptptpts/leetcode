# Number of Islands

## Problem

Given an m x n 2D binary grid `grid` which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Input

Two dimension integer array that contains only `1` and `0`.

## Example

- Example 1:

>Input: grid = [  
["1","1","1","1","0"],  
["1","1","0","1","0"],  
["1","1","0","0","0"],  
["0","0","0","0","0"]  
]  
Output: 1

- Example 2:

>Input: grid = [  
["1","1","0","0","0"],  
["1","1","0","0","0"],  
["0","0","1","0","0"],  
["0","0","0","1","1"]  
]  
Output: 3  

## Constraints

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 300
- grid[i][j] is '0' or '1'.

## Output

A number of islands in the given grid.

## Solution 1

We need to mark the lands we visited as the different number without 0
or 1. So, we can use 2 for check we already visit this land. After then,
we need to traverse all the adjacent lands when we find a land we did not
visit yet. For traverse all the adjacent lands, we can use a queue to
keep the adjacent lands contains in a current island. And, if we traverse
all the grid, we will find all the islands in the grid.

For example, we'll start to traverse the given grid from (0,0) to (m,n).
If we find a '1', we can change to find all the lands included in this
island. To find all the lands, we'll push adjacent lands from a current
land, and mark a current land as 2 to not visit this land again. We'll
repeat this process until a queue is empty, and increase a number of
island after finding all the lands in this island. After then, we'll
return the previous logic to traverse the given grid, and this job will
finish when we find the end of this grid.

A time complexity is O(m * n) because we need to traverse all the element
in the given grid.  
A space complexity is O(m * n) because we need to save all the points in
the given grid in the worst case.

- Time complexity: O(m * n)
- Space complexity: O(m * n)
