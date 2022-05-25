# Container With Most Water

## Problem

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

**Notice** that you may not slant the container.

## Input

Integer array that contains a height of wall

## Example

- Example 1:

>Input: height = [1,8,6,2,5,4,8,3,7]  
Output: 49  
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

- Example 2:

>Input: height = [1,1]  
Output: 1
 
## Constraints

- n == height.length
- 2 <= n <= 10^5
- 0 <= height[i] <= 10^4

## Output

The maximum amount of water a container can store

## Solution 1

Amount of water a container can store in two wall `i` and `j` can be calculated by the below function f(i, j).

>f(i, j) = (`j`-`i`) * Min(wall(`i`), wall(`j`))

With this function, we can start to find the maximum amount of water from f(0, length - 1) because it make (`j`-`i`) as the maximum.  
After then, we can move a cursor that point a smaller wall to the other side because Min(wall(`i`), wall(`j`)) depends on a smaller wall. So, if wall(`i`) is a smaller one, we need to move `i` to right side until find a higher wall than the previous wall(`i`).  
When we find another wall for a new `i` and `j`, we can calculate an amount of water a new container can store. And if it is larger than the previous maximum amount of water, we can replace it.

A time complexity is O(n) because it traverse the given array by forward and backward with two cursor `i` and `j`. This logic will be end when `i` and `j` cross each other, so we visit each element only once.  
A space complexity is O(1) because we save only the previous wall and the maximum amount of water.

- Time complexity: O(n)
- Space complexity: O(1)
