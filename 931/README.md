# Minimum Falling Path Sum

## Problem

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

## Input

Two dimension integer array

## Example

- Example 1:

>Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]  
Output: 13  
Explanation: There are two falling paths with a minimum sum as shown.

- Example 2:

>Input: matrix = [[-19,57],[-40,-5]]  
Output: -59  
Explanation: The falling path with a minimum sum is shown.

## Constraints

- n == matrix.length == matrix[i].length
- 1 <= n <= 100
- -100 <= matrix[i][j] <= 100

## Output

The minimum sum can be made by a falling path

## Solution 1

If we know the minimum sum of a falling path at the previous row, we can find the minimum sum of a current element by adding a current value with the minimum value of the climbing path. So, the minimum sum of a falling path at the `matrix[i][j]` f(i, j) can be find by the below function.

>f(i, j) = Min(f(i-1, j-1), f(i-1, j), f(i-j, j+1)) + matrix[i][j]

And, the first row of the given matrix contains the minimum sum of a falling path at each position because the first row does not have any previous elements. Therefore, we can find the minimum sum of a falling path on each element by finding the minimum value from the first row.

A time complexity is O(n^2) because we need to traverse an entire array at least once.  
A space complexity is O(1) because we can use the given matrix to saving the minimum sum of a falling path on each element.

- Time complexity: O(n^2)
- Space complexity: O(1)
