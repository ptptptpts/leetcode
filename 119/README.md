# Pascal's Triangle II

## Problem

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

## Input

Row index of Pascal's triangle

## Example

- Example 1:

>Input: rowIndex = 3  
Output: [1,3,3,1]

- Example 2:

>Input: rowIndex = 0  
Output: [1]

- Example 3:

>Input: rowIndex = 1  
Output: [1,1]

## Constraints

- 0 <= rowIndex <= 33

## Output

Nth row of Pascal's triangle

## Solution 1

Solution is same with the Pascal's Triangle I problem, but we don't need to save all the previous history. To build a `n`th row of Pascal's triangle, the only thing we need is a `n-1`th row of Pascal's triangle. So, we need to hold the last row of Pascal's triangle when build each row.

A time complexity is O(rowIndex^2) because we need to build all the elements of Pascal's triangle with `n` rows. A number of elements depends on n^2, so a time complexity is O(rowIndex^2).  
A space complexity is O(rowIndex) because we save only the last row of Pascal's triangle.

- Time complexity: O(rowIndex^2)
- Space complexity: O(rowIndex)
