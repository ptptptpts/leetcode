# Set Matrix Zeroes

## Problem

Given an m x n integer matrix `matrix`, if an element is 0, set its entire row and column to 0's.

You must do it in place.

## Input

Two dimension integer matrix

## Example

- Example 1:

>Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]  
Output: [[1,0,1],[0,0,0],[1,0,1]]

- Example 2:

>Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]  
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

## Constraints

- m == matrix.length
- n == matrix[0].length
- 1 <= m, n <= 200
- -2^31 <= matrix[i][j] <= 2^31 - 1

## Output

The matrix updated the entire row and column as '0' if an element is 0

## Solution 1

Basically, if an element is 0, all the elements in the same row and column does not have
any information because they will be updated to 0. Next, if we update the matrix when we
find a `0` element, it will update the elements we don't check yet. So, it will remove an
information we did not check yet, and it means we can't update the matrix correctly if
some elements are 0 in the column and row we updated. Therefore, we need to find all the
zeros in the matrix first, and update them to the array.

To save all the zeros in the matrix, we can use the given matrix. Because the same column
and rows can be ignored if it has many zeros in the same column or rows, we can keep only
one zero in each column and row. So, we can use the first element in each row and column
to mark this row and column will be overwritten as zero. But, this solution use the first
row and column to save the zero information, we need to save the first row and column is
zero or not in the two variables.

Next, when we update the matrix as zero, we need to update the matrix from the end to 
start, because it will overwrite all the first row and column if we start to update the
array from start to end.

A time complexity is O(mn) because we need to search all the zeros in the matrix at least
once.  
A space complexity is O(1) because we use only two additional variables to save the first
row and column has zero or not.  

- Time complexity: O(mn)
- Space complexity: O(1)
