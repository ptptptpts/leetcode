# Pascal's Triangle

## Problem

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

## Input

Number of rows in Pascal's triangle

## Example

- Example 1:

>Input: numRows = 5  
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

- Example 2:

>Input: numRows = 1  
Output: [[1]]

## Constraints

1 <= numRows <= 30

## Output

Pascal's trangle with the given rows

## Solution 1

At `n`th row of Pascal's triangle, we can build it by adding 1 at the start of end of a current row, and calculate a middle of a current row by adding two integers from the previous row.

A time complexity is O(numRows^2) because we need to build all the elements in `n`th row of Pascal's triangle. A number of elements in Pascal's triangle depends on n^2, so a time complexity is O(numRows^2)
A space complexity is O(numRows^2) because we need to save all rows in a List.

- Time complexity: O(numRows^2)
- Space complexity: O(numRows^2)
