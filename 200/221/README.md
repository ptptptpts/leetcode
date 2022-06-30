# Maximal Square

## Problem

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

## Input

Two dimension integer array

## Example

- Example 1:

>Input: matrix =  
[["1","0","1","0","0"],  
["1","0","1","1","1"],  
["1","1","1","1","1"],  
["1","0","0","1","0"]]  
Output: 4

- Example 2:

>Input: matrix =  
[["0","1"],  
["1","0"]]  
Output: 1

- Example 3:

>Input: matrix = [["0"]]  
Output: 0

## Constraints

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 300
- matrix[i][j] is '0' or '1'.

## Output

Size of the largest square containing only 1

## Solution 1

If we found a square while searching from left-top to right-bottom, it means its size is the shortest path contains `1`. Let's assume we find a square containing only 1 with a size 3 like the below.

>0 0 0 0 0  
0 1 1 1 1  
0 1 1 1 0  
0 1 1 1 0  
0 0 1 1 1

If we record the minumum number of `1` when we need to cross while going to the position from left-top, it could be like the below.

>0 0 0 0 0
0 1 1 1 1
0 1 2 2 0
0 1 2 3 0
0 0 1 2 1

But, let's assume a square that has only the boundary like the below.

>0 0 0 0 0
0 1 1 1 1
0 1 0 0 1
0 1 0 0 1
0 1 1 1 1

In this case, if we found the minumum number only from its left and upper side, it could not find the `0` in its diagonal position like the below.

>0 0 0 0 0
0 1 1 1 1
0 1 0 0 1
0 1 0 0 1
0 1 1 1 2

At the [4, 4] position, the minimum number of `1` in its left and up is 1, so this logic find a size of the largest square is `2 ^ 2`.  
To check an empty square, we need to find the path containing the least `1` to reach [i, j] from [i-1, j], [i, j-1], and [i-1, j-1].  
Then, we can convert the problem to build a map contains the minimum number of `1` that a robot need to cross to each position when a robot can move to right, down, and right-down, and find the maximum number from the map.

The time complexity is O(n*m) because we need to find the minimum number of `1` need to cross on each position.  
The space complexity is O(m) because we need to save only the previous row to find the minum number of `1` on each row.

- Time complexity: O(n * m)
- Space complexity: O(m)
