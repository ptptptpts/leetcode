# Matrix Block Sum

## Problem

Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

- i - k <= r <= i + k,
- j - k <= c <= j + k, and
- (r, c) is a valid position in the matrix.

## Input

Two dimensions integer array and a range of matrix `k`

## Example

- Example 1:

>Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1  
Output: [[12,21,16],[27,45,33],[24,39,28]]

- Example 2:

>Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2  
Output: [[45,45,45],[45,45,45],[45,45,45]]

## Constraints

- m == mat.length
- n == mat[i].length
- 1 <= m, n, k <= 100
- 1 <= mat[i][j] <= 100

## Output

Two dimensions integer array that contains a sum of subarray.

## Solution 1

We can describe any matrix as its left top (i1, j1) and right bottom (i2, j2) corner. And its sum of integer f(i1, j1, i2, j2) as the below function.

>f(i1, j1, i2, j2) = f(0, 0, i2, j2) - f(0, 0, i1, j2) - f(0, 0, i2, j1) + f(0, 0, i1, j1)

So, if we can find a sum of any matrix in a constant time if we have a sum of subarray at each element.

A time complexity is O(n \* m) because we need to calculate a sum of subarray on each element, and need to find a sum of matrix block sum again.  
A space complexity is O(n \* m) because we need to save a sum of subarray on each element, and need to collect a matrix block sum again.

- Time complexity: O(n * m)
- Space complexity: O(n * m)
