# Roman to Integer

## Problem

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol|Value
---|---
I|             1
V|             5
X|             10
L|             50
C|             100
D|             500
M|             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

- I can be placed before V (5) and X (10) to make 4 and 9.
- X can be placed before L (50) and C (100) to make 40 and 90.
- C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

## Input

The string that contains a roman numerals

## Example

- Example 1:

>Input: s = "III"  
Output: 3  
Explanation: III = 3.  

- Example 2:

>Input: s = "LVIII"   
Output: 58  
Explanation: L = 50, V= 5, III = 3.

- Example 3:

>Input: s = "MCMXCIV"  
Output: 1994  
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

## Constraints

- 1 <= s.length <= 15
- s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
- It is guaranteed that s is a valid roman numeral in the range [1, 3999].

## Output

Integer that converts the given roman numeral.

## Solution 1

Basically, we can convert each roman numeric character to the matched
integer. And then, we have a corner case that represent a `4` or `9` by
using two roman character. Actually, a roman numeral write a character
from a larger one to a smaller once. But, in this case that representing
`4` or `9`, it writes a small character `1` before a larger character
`5` or `10`. So, we need to keep the previous integer and compare it
with a current integer to find this corner case.  

A time complexity is O(s.length) because we need to convert each roman
numeral character.  
A space complexity is O(1) because we save only the previous integer
to find a corner case that represents `4` or `9`.

- Time complexity: O(s.length)
- Space complexity: O(1)
