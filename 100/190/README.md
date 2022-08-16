# Reverse Bits

## Problem

Reverse bits of a given 32 bits unsigned integer.

Note:

- Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.

## Input

Signed integer x

## Example

- Example 1:

>Input: n = 00000010100101000001111010011100  
Output:    964176192 (00111001011110000010100101000000)  
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

- Example 2:

>Input: n = 11111111111111111111111111111101  
Output:   3221225471 (10111111111111111111111111111111)  
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

## Constraints

- The input must be a binary string of length 32

## Output

Bitwise reversed integer x 

## Solution 1

Basically, we can reverse the given integer by four bitwise operations in 32 loops.
First, we can pick the least significant bit from the integer x. Next, we'll shift the
reversed x once by the left. Next, we'll add the LSB of the integer x by `|` operation.
Last, we'll shift the integer x once by the right. Then, we can find the reversed x
by four operations in 32 loops.

A time complexity is O(1) because it does not depend on a range of the integer x.   
A space complexity is O(1) because it uses only one integer to save a reversed x.

- Time complexity: O(1)
- Space complexity: O(1)
