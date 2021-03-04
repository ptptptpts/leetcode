# Reverse Integer

## Problem

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

## Input

Signed integer
  
## Constraints

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

## Output

Return reverse integer

## Solution

0) Multiple the result by 10
1) Get modular of the given integer by 10 and add it on result
2) Divide the given integer by 10
3) If the given integer is 0, finish the job. If not, return to 0
4) If the result is not in the 32 bit integer range, change it to 0

If the given integer is less than 0, modular will return a minus value.  
So, we don't need to check minus on here.

- Time complexity: O(logn)
- Space complexity: O(1)
