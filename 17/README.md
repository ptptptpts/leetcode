# Letter Combinations of a Phone Number

## Problem

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

.|.|.
----|----|----
1|2(abc)|3(def)
4(ghi)|5(jkl)|6(mno)
7(pqrs)|8(tuv)|9(wxyz)
*|0|#

## Input

String that contains a character only in the range ['2', '9']

## Example

- Example 1:

>Input: digits = "23"  
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

- Example 2:

>Input: digits = ""  
Output: []

- Example 3:

>Input: digits = "2"  
Output: ["a","b","c"]

## Constraints

- 0 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## Output

All the available combinations by the given string

## Solution 1

To build all the available combinations, there are no solution to build them as O(n) like solution. We need to build all the available strings by changing each integer to the characters in keypad.  
However, there are two solutions that can improve a performance of the solution.  

The first one is that converting a digit by a dictionary. Each digit has the available characters for them, and it never changed. So, we can save them as a two dimension array and directly access to there without a if statement.  

The second one is using StringBuilder instead of String. In Java, adding two String or String + character is converted to change the String to StringBuilder, append two StringBuilder, and changing the StringBuilder to a String. So, if we use a StringBuilder, we can remove the first step that change a String to a StringBuilder.

A time complexity is O(4^n) because '7' and '9' can be converted one of the four characters in a keypad, and a number of available Strings is 4^n.  
A space complexity is O(4^n) because we need to save all the available Strings.

- Time complexity: O(4^n)
- Space complexity: O(4^n)
