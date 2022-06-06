# Valid Anagram

## Problem

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Input

Two strings s and t

## Example

- Example 1:

>Input: s = "anagram", t = "nagaram"  
Output: true

- Example 2:

>Input: s = "rat", t = "car"  
Output: false

## Constraints

- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of lowercase English letters.

## Output

True if the `t` is an anagram of the `s`

## Solution 1

If the `t` is an anagram of the `s`, it means it contains each character of the `s` as same number.
So, we can find the `t` is anagram or not by counting each character from the `s` and `t` and
comparing them each other. If two counters are same, the `t` is an anagram of the `s`.

`n` is a length of the `s` and `t`.  
A time complexity is O(n) because we need to search all the characters in `s` and `t` to count each
character.  
A space complexity is O(1) because we always use two arrays with a size as a number of alphabet. 

- Time complexity: O(n)
- Space complexity: O(1)
