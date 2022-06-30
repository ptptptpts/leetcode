# Decode String

## Problem

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 10^5.

## Input

Encoded String

## Example

- Example 1:

>Input: s = "3[a]2[bc]"  
Output: "aaabcbc"

- Example 2:

>Input: s = "3[a2[c]]"  
Output: "accaccacc"

- Example 3:

>Input: s = "2[abc]3[cd]ef"  
Output: "abcabccdcdcdef"

## Constraints

- 1 <= s.length <= 30
- s consists of lowercase English letters, digits, and square brackets '[]'.
- s is guaranteed to be a valid input.
- All the integers in s are in the range [1, 300].

## Output

Decoded String

## Solution 1

We can assume this problem is similar with finding a valid parentheses.
First, we have two kinds of input, one is integer, and the other one is lowercase character.
When we meet any integer character, we need to collect all integers until we meet an open square bracket.
And, if we meet any lowercase character, we need to collect them until we meet a close square bracket.
Next, if we meet a close square bracket, the string inside the bracket will be applied multiple times with the last integer before the bracket.
So, it means we need to use a stack to save a number of repeat of each string and pop it when we meet a close square bracket.

If we find an integer, push a current string to a string stack and read an integer.

If we find a Character, append it to a current string.

If we find an open bracket, push a current integer to an integer stack and create a new string.

If we find a close bracket, push a current string to a string stack.
And, pop a string stack and an integer stack, and repeat the return of a string stack in the number of an integer stack.
And, append the result to a top of a string stack

A time complexity is O(n), because we need to search all the characters in an encoded string.  
A space complexity is O(n), because a length of decoded string has a dependency with the encoded string.

- Time complexity: O(n)
- Space complexity: O(n)
