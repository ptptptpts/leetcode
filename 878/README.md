# Roman to Integer

## Problem

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol | Value |
----|----|
I | 1
V | 5
X | 10
L | 50
C | 100
D | 500
M | 1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.  
X can be placed before L (50) and C (100) to make 40 and 90.  
C can be placed before D (500) and M (1000) to make 400 and 900.  
Given a roman numeral, convert it to an integer.

## Input

String that describe Roman

## Example

Input: s = "III"  
Output: 3  
Example 2:

Input: s = "IV"  
Output: 4  
Example 3:

Input: s = "IX"  
Output: 9  
Example 4:

Input: s = "LVIII"  
Output: 58  
Explanation: L = 50, V= 5, III = 3.  
Example 5:

Input: s = "MCMXCIV"  
Output: 1994  
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

## Constraints

- 1 <= s.length <= 15
- s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
- It is guaranteed that s is a valid roman numeral in the range [1, 3999].

## Output

Integer convert the input Roman

## Solution 1

Input is guaranteed that s is a valid roman in the range 1, 3999. So, we don't need to care about invalid case.

Roman I always describe 1.

Roman M describe 1000, but it is 800 to make 900 if a result already has 100.  
Roman C describe 100, but it is 80 to make 90 if a result already has 10.  
Roman X describe 10, but it is 8 to make 9 if a result already has 1.

Roman D describe 500, but it is 300 to make 400 if a result already has 100.  
Roman L describe 50, but it is 30 to make 50 if a result already has 10.  
Roman V describe 5, but it is 3 to make 5 if a result already has 1.

The Time complexity is O(n), because it depends on a length of the input String.

The Space complexity is O(1), because it uses only one integer.

- Time complexity: O()
- Space complexity: O(1)
