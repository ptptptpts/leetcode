# Perfect Squares

## Problem

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

## Input

Integer n

## Example

- Example 1:

>Input: n = 12  
Output: 3  
Explanation: 12 = 4 + 4 + 4.

- Example 2:

>Input: n = 13  
Output: 2  
Explanation: 13 = 4 + 9.

## Constraints

- 1 <= n <= 10^4

## Output

The least number of perfect square numbers that make the integer n by sum of them.

## Solution 1

Let's assume we already know the least number of perfect squared numbers until the integer `i`. Then, we can find the least number at the integer `i` by comparing all the possible numbers that can reach with the squared number to the integer `i`. For example, if we already know the least number of perfect squared numbers `f(i)` until the integer `i`, we can move to the integer `i` from `i - 1*1`, `i - 2*2`, `i - 3*3`, and so on. Then, they will have a number of perfect squared numbers `f(i-1*1) + 1`, `f(i-2*2) + 1`, `f(i-3*3) + 1`, and so on, and we can find the least number of perfect squared numbers by finding the least numbers from there.

A time complexity is O(n^2), because we need to find the least number of perfect square numbers until the integer n and need to compare until the square root of the integer n on each number.  
A space complexity is O(n), because we need to save all the previous least number of perfect squared numbers until the integer n.

- Time complexity: O(n^2)
- Space complexity: O(n)
