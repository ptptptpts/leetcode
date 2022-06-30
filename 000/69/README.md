# Sqrt(x)

## Problem

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

## Input

Non-negative integer in 32 bit range

## Example

- Example 1:

>Input: x = 4  
Output: 2

- Example 2:

>Input: x = 8  
Output: 2  
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

## Constraints

- 0 <= x <= 2^31 - 1

## Output

The integer part of a square root of the given number.

## Solution 1

First, a square root of the given number is lower than the given number `n`. So, we can assuem it should be in [0, `n`) range. Next, we can search this range by binary search. If a square of a current mid is larger than `n`, a sqrt is in a larger half of a current space. On the other side, it will be in a smaller half range of a current space.  

A time complexity is O(logn) because we search a range by a binary search.  
A space complexity is O(1) because we don't save anything in a memory.

- Time complexity: O(logn)
- Space complexity: O(1)
