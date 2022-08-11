# Reverse Integer

## Problem

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

## Input

Signed 32-bit integer x

## Example

- Example 1:

>Input: x = 123  
Output: 321  

- Example 2:

>Input: x = -123  
Output: -321

- Example 3:

>Input: x = 120  
Output: 21

## Constraints

- -2^31 <= x <= 2^31 - 1

## Output

Reversed integer x. If the reversed x is outside the 32-bit range, return 0.

## Solution 1

Basically, we can exceed the 32-bit range while reverse the integer x. So, it is better
to start from converting the integer x to 64-bit integer and convert it in 64-bit range.
After then, we can compare the output is in 32-bit range or not, and change the reverse
as 0 if it is outside the 32-bit range.

To reverse the integer digit, we can simply do it by modular the integer x by 10 and
divide it again as 10. In each loop, we'll multiply the reverse as 10 and add the modular
to the reverse.

A time complexity is O(1), because a range of 32-bit integer is fixed.  
A space complexity is O(1), because we don't save any history or something.

- Time complexity: O(1)
- Space complexity: O(1)
