# Search a 2D Matrix

## Problem

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

## Input

2D integer matrix and a target integer

## Example

- Example 1:

>Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3  
Output: true

- Example 2:

>Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13  
Output: false

## Constraints

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 100
- -10^4 <= matrix[i][j], target <= 10^4

## Output

True if the target integer is in the 2D matrix

## Solution 1

In this problem, we need to find a row and column to find the target integer is in the
matrix or not. And, to find the row and column, we can use a binary search. When we find
a row of the target integer, we don't need to find the target exactly because the row
can contain the target integer. So, if the first element of some row is lower or equal
than the target integer, and the first element of its next row is higher than the target
integer, this row can contain the target integer. Next, we can use a binary search in
this row to find the target integer. In this case, we need to find the target integer
exactly.

A time complexity is O(log m + log n), because we find a row and column by binary search.
A space complexity is O(1), because we use a binary search, and it saves only the first
and the last position of a current window.

- Time complexity: O(log m + log n)
- Space complexity: O(1)
