# Unique Paths

## Problem

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

## Input

Integer m and n

## Example

Input: m = 3, n = 2  
Output: 3  
Explanation:  
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:  

1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Input: m = 7, n = 3  
Output: 28  

Input: m = 3, n = 3  
Output: 6  

## Constraints

1 <= m, n <= 100  
It's guaranteed that the answer will be less than or equal to 2 * 10^9.  

## Output

Integer, a number of unique path can reach the bottom-right coner.

## Solution 1

On the top of the grid, we have only one unique path to reach there because there are only one route. At the same way, we have only one unique path to reach to the left of the grid.  

On each step, the robot can move to only right or down. So, on each grid, it can be moved from left or up grid. Therefore, a number of unique path on each grid is sum of a number of unique path on left and up grid.

The Time complexity is O(m * n) because it need to find a number of unique path on all the grids.

The space complexity is O(m * n) because it need to save a number of unique path on all the grids.

- Time complexity: O(m * n)
- Space complexity: O(m * n)

## Solution 2

Improve from the solution 1, we don't need to keep all of the previous grids because we use only the last up or left layer when calculating each layer.  
For example, if we calculate a number of unique path by each row, we need to keep only the last row to calculate the current row.  

When calculating each row, an each item in an array saves the previous value and is updated to the current value when it updated.  

For example, the initial array will save an unique path of the first row.

Array | 1 | 1 | 1 | 1 | 1 |

Because the first column is fixed as '1', we can start to calculate from the second column. A number of unique path of the second column is sum of the previous column and current column because it holds a number of unique path on the previous row.  
In conclusion, a number of unique paths in the second row will be calculated by the below step.  

Array | 1 | 2 | 1 | 1 | 1 |  
Array | 1 | 2 | 3 | 1 | 1 |  
Array | 1 | 2 | 3 | 4 | 1 |  
Array | 1 | 2 | 3 | 4 | 5 |  

The Time complexity is same as the solution 1.

The Space complexity is O(m) or O(n) because it need to save the only the last row or column.

- Time complexity: O(m * n)
- Space complexity: O(m)
