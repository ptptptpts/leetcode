# Longest Palindromic Substring

## Problem

Given a string s, return the longest palindromic substring in s.

## Input

String s

## Example

- Example 1:

>Input: s = "babad"  
Output: "bab"  
Explanation: "aba" is also a valid answer.

- Example 2:

>Input: s = "cbbd"  
Output: "bb"

## Constraints

- 1 <= s.length <= 1000
- s consist of only digits and English letters.

## Output

The longest palindromic substring can be made by the given String s

## Solution 1

If we know the longest palindrom string end with the `i`th character, the longest possible palindrom string end with the `i+1`th character contains the previous palindrom string. For example, if a start and end of the previous palindrom are `s` and `e`, the possible longest palindrom string can be made by `s-1` and `e+1`. If it is not a palindrom, we can find a start of the longest palindrom that end with the current character `e+1` from `s-1` to `e+1`.

A time complexity is O(n^2) because we find the longest palindrom string on each character.  
A space complexity is O(1) because we save only a start and end of the longest palindrom.

- Time complexity: O(n^2)
- Space complexity: O(1)
