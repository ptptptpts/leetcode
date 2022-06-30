# Valid Parentheses

## Problem

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

## Input

String s containing just the characters '(', ')', '{', '}', '[' and ']'

## Example

- Example 1:

>Input: s = "()"  
Output: true

- Example 2:

>Input: s = "()[]{}"  
Output: true

- Example 3:

>Input: s = "(]"  
Output: false

## Constraints

- 1 <= s.length <= 10^4
- s consists of parentheses only '()[]{}'.

## Output

True if all the brackets are closed in the correct order.

## Solution 1

If a `n` th character is one of open brackets, push it to a stack. If a `n`th character is one of close brackets, peek a top of the stack and pop it if it is a same type of a bracket. If it is a different type of bracket, return false because a bracket does not closed by a correct order. In additional, if the stack is not empty even if we traverse all the array, return false because a String have open brackets more than close brackets.

A time complexity is O(n) because we need to traverse a String from start to end.  
A space complexity is O(n) because we need to save all the characters in a stack in the worst case.

- Time complexity: O(n)
- Space complexity: O(n)
