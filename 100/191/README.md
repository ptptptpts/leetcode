# Number of 1 Bits

## Problem

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

- Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.

## Input

An unsigned integer

## Example

- Example 1:

>Input: n = 00000000000000000000000000001011  
Output: 3  
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.  

- Example 2:

>Input: n = 00000000000000000000000010000000  
Output: 1  
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.  

- Example 3:

>Input: n = 11111111111111111111111111111101  
Output: 31  
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

## Constraints

- The input must be a binary string of length 32.

## Output

A number of 1 bits of the given unsigned integer

## Solution 1

The given integer is in 32 bits, so we need to compare 32 times to check each bit is `1`
or `0`. To check a bit, we can use a bitwise `&`, and shift a current bit to left on each
loop.

A time complexity is O(1) because we always compare 32 times to check all the bits in
integer range.  
A space complexity is O(1) because we just save a current bit filter.

- Time complexity: O(1)
- Space complexity: O(1)
