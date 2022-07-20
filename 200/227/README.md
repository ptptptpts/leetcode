# Basic Calculator II

## Problem

Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

## Input

String s which represents an expression

## Example

-Example 1:

>Input: s = "3+2*2"  
Output: 7

- Example 2:

>Input: s = " 3/2 "  
Output: 1

- Example 3:

>Input: s = " 3+5 / 2 "  
Output: 5

## Constraints

- 1 <= s.length <= 3 * 10^5
- s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
- s represents a valid expression.
- All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
- The answer is guaranteed to fit in a 32-bit integer.

## Output

A result after evaluate the given expression

## Solution 1

First, we can find an integer and operator from the given expressions when we find
another type of character during searching the string. If we find an empty space, we can
ignore it. If we find an integer character, we can append it to the current integer. And,
if we find an operator, we can close the current integer and read a current character as
an operator. Then, we can parse all the integers and operators from the given expression.

Next, we need to calculate the given expression. When we complete to find a new integer,
we can push it to a stack. After then, if we find a '+' or '-' operator, we can't decide
it is okay to calculate it or not because '*' and '/' has higher priority than them. And,
if we find a '*' or '/' operator, we can calculate it immediately. If we find a '+' or
'-' again after finding a '+' or '-', we can calculate the previous operator. To keep the
previous operator and integers, we can use two stacks for operator and integer.

A time complexity is O(n) because we can find a result after traverse the given
expression.  
A space complexity is O(1) because actually we save only two integers and one operator
to a stack.

- Time complexity: O(n)
- Space complexity: O(1)
