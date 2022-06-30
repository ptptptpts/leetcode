# Trapping Rain Water

## Problem

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Input

Integer array that contains a height of each bar

## Example

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]  
Output: 6  
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.  

Example 2:

Input: height = [4,2,0,3,2,5]  
Output: 9

## Constraints

- n == height.length
- 0 <= n <= 3 * 10^4
- 0 <= height[i] <= 10^5

## Output

Integer, a size of water trapped after raining.

## Solution 1

Scan from left and find how much water can be trapped if the most right map (n + 1 position) has an infinity wall.  
Scan from right and find how much water can be trapped if the most left map (-1 position) has an infinity wall.  
Compare two results on each position and sum the smallest value on each position.  

The Time complexity is O(n), because it traverse each array three times from left to right, from right to left, and compare from left to right.

The Space complexity is O(n), because it use two additional arrays that have the same size with the input array.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

From the tallest bar, we can calculate a size of trapped water in a left side of the tallest bar by scanning from left to right. And alo we can calculate a size of trapped water in a right side of the tallest bar by scanning form right to left.  

Using two cursors moving from left to right and moving from right left, if a height of a left cursor is lower than a height of a right cursor, move the left cursor to right, else move the right cursor to left.  
On each round, plus a trapped water at the moved cursor to summary, and repeat this until the left and right cursor locate on the same position.  

The Time complexity is O(n), because it traverse the input array only one time by two cursors from left to right and right to left.

The Space complexity is O(1), because it saves only a size of a trapped water in current round and some information of the previous round.

- Time complexity: O(n)
- Space complexity: O(1)
