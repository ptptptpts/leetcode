# Reverse String

## Problem

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

## Input

Character Array  
  
## Constraints

You may assume all the characters consist of printable ascii characters.

## Output

Put reversed string in the given array

## Solution

Swap i th item with n-i th item.
Repeat it on n/2 range.

- Time complexity: O(n)
- Space complexity: O(1)
