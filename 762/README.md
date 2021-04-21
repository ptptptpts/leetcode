# Hamming Distance

## Problem

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

## Input

Two integer x and y

## Example

Input: x = 1, y = 4  
Output: 2  

Input: x = 3, y = 1  
Output: 1

## Constraints

- 0 <= x, y <= 2^31 - 1

## Output

A number of difference bits bitween x and y.

## Solution 1

Compare the last bit of the two integers and count if they are different.  
And repeat this compare 32 times while logical right shift on each loop.

The Time complexity is O(n) because it depends on a size of input integer.

The Space complexity is O(1) because it does not use any additional memory.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

Xor two integers and find 1 bit from a result of xor.

The Time complexity is O(n) because it depends on a size of input integer.

The Space complexity is O(1) because it does not use any additional memory.

- Time complexity: O(n)
- Space complexity: O(1)
