# Power of Three

## Problem

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

## Input

Integer

## Example

Input: n = 27  
Output: true

Input: n = 0  
Output: false

Input: n = 9  
Output: true

Input: n = 45  
Output: false

## Constraints

- -2^31 <= n <= 2^31 - 1

## Output

True if input is a power of three.

## Solution 1

Divide an input by 3 until it goes 1 and count how many we divide it.
After then, multiple 1 by 3 again as many as we divided, and compare it with the input.
If the input is same with the result, it is a power of three.

The Time complexity is O(n) because it depends on a size of input integer.

The Space complexity is O(1) because it does not use any additional memory.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

If number N is 3^M, it can be divided by 3^0, 3^1, 3^2, ... , 3^M-1.
We can find the maximum M in integer range by log3(Max integer) and it is

log3(Max integer) = log3(2^31 - 1) = log10(2^31 - 1) / log10(3) = 19.56

So, the maximum M in integer range is 19 and the largest power of 3 in integer range is 3^19.

In conclusion, if the input is larger than 0 and 3^19 % N is 0, the input N is a power of 3.

The Time complexity is O(1) because it can find a power of 3 by one compare and one modular.

The Space complexity is O(1) because it does not use any additional memory.

- Time complexity: O(1)
- Space complexity: O(1)

## Solution 3

If a number is power of 10, it can be described by '^10*$' regex in decimal.
Same with this, if a number is power of 3, it can be described as '^10*$' regex in base 3.

So, convert the input as base 3 and check it satisfy the regex '^10*$'. If the input satisfy the regex, it is power of 3.

The Time complexity is O(n) because a cost to convert to base 3 is based on a size of integer.

The Space complexity is O(1) because it does not use any additional memory.

- Time complexity: O(n)
- Space complexity: O(1)
