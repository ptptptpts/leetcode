# Triangle

## Problem

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

## Input

A list that contains a List of integer

## Example

- Example 1:

>Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]  
Output: 11  
Explanation: The triangle looks like:  

```bash
   2  
  3 4  
 6 5 7  
4 1 8 3  
```

>The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).  

- Example 2:

>Input: triangle = [[-10]]  
Output: -10

## Constraints

- 1 <= triangle.length <= 200
- triangle[0].length == 1
- triangle[i].length == triangle[i - 1].length + 1
- -10^4 <= triangle[i][j] <= 10^4

## Output

The minimum path sum from top to bottom.

## Solution 1

At the `i` th row and `j` th element, we can move to this element from `(i-1, j-1)` and `(i-1, j)` because index `i` can move to the `i` or `i+1` of the next row. So, the minimum path sum `f(i, j)` is a sum of a current cost and a smaller one between `f(i-1, j-1)` and `f(i-1, j)`.

A time complexity is O(n^2) because we need to traverse all the elements in the given triangle.  
A space complexity is O(1) because we can save the minimum path sum on each element and don't need any extra space.

- Time complexity: O(n^2)
- Space complexity: O(1)
