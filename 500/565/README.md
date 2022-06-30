# Number of 1 Bits

## Problem

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.

## Input

Integer

## Example

Input: n = 00000000000000000000000000001011  
Output: 3  
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Input: n = 00000000000000000000000010000000  
Output: 1  
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Input: n = 11111111111111111111111111111101  
Output: 31  
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

## Constraints

The input must be a binary string of length 32.

## Output

A number of 1 bits in integer

## Solution 1

Count the least bit of integer is 1 or not and logical shift right until a number is 0.

The Time complexity is O(n) because it depends on the most significant bit of the input integer.

The Space complexity is O(1) because it does not use any additinal memory.

- Time complexity: O(n)
- Space complexity: O(1)
