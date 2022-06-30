# Longest Common Subsequence

## Problem

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

- For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

## Input

Two strings text1 and text2

## Example

- Example 1:

>Input: text1 = "abcde", text2 = "ace"  
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

- Example 2:

>Input: text1 = "abc", text2 = "abc"  
Output: 3  
Explanation: The longest common subsequence is "abc" and its length is 3.

- Example 3:

>Input: text1 = "abc", text2 = "def"  
Output: 0  
Explanation: There is no such common subsequence, so the result is 0.

## Constraints

- 1 <= text1.length, text2.length <= 1000
- text1 and text2 consist of only lowercase English characters.

## Output

The longest common subsequence String can be made by the text1 and text2.

## Solution 1

Let's assume we already know the longest common subsequence on each position of the text1. Then, if some character is added in the text2, we can find the longest common subsequence by comparing with the previous history.  
For example, we will traverse the text 1 with finding the longest subsequence on the previous characters `l` to find a length of subsequence with a new character. If we find a new character from the position `p` of the text 1, we know the new longest subsequence with this character will be `l + 1`. But, we already know the previous longest subsequence `q` on this position `p`. Then, if `l + 1` is larger than `q`, we can replace the longest subsequence of the position `p` as `l + 1`.

`n` is a length of the text1, `m` is a length of the text2.  
A time complexity is O(n * m), because we need to traverse the other String whenever we check the `i`th character of the text.  
A space complexity is O(n), because we save a length of the longest subsequence on each character.

- Time complexity: O(n * m)
- Space complexity: O(n)
