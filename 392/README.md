# Is Subsequence

## Problem

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

## Input

Two String s and t

## Example

- Example 1:

>Input: s = "abc", t = "ahbgdc"  
Output: true

- Example 2:

>Input: s = "axc", t = "ahbgdc"  
Output: false

## Constraints

- 0 <= s.length <= 100
- 0 <= t.length <= 10^4
- s and t consist only of lowercase English letters.

## Output

Return true if the String s is a subsequence of the String t

## Solution 1

If the String s is a subsequence of the String t, `n + 1`th character of the String s will be in the next of `n`th character from the String t because a subsequence keep an order of the String. It means we don't need to care about the previous character if we find the `n`th character of the String s from the String t.  
Then, we can find the String s is a subsequence or not by using two cursors. Two cursors point the String s and t, and the cursor in String t will move to the next character until it meet the end of the String t. And the cursor in String s will move to the next character if the cursor in String t is the same character. If the cursor in the String s meet the end of the String s, the String s is a subsequence of the String t.

A time complexity is O(t), because we find each character of the given String s from the String t. It can be O(s) because the logic is finished when we find the end of the given String s, but O(t) is more appropriate because `t` is heavier than `s`.  
A space complexity is O(1), because we don't need any extra space to save something.

- Time complexity: O(t)
- Space complexity: O(1)
