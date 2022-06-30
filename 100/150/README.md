# Evaluate Reverse Polish Notation

## Problem

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

**Note** that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

## Input

Array of Strings that contains an arithmetic expression in RPN

## Example

- Example 1:

>Input: tokens = ["2","1","+","3","*"]  
Output: 9  
Explanation: ((2 + 1) * 3) = 9

- Example 2:

>Input: tokens = ["4","13","5","/","+"]  
Output: 6  
Explanation: (4 + (13 / 5)) = 6

- Example 3:

>Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]  
Output: 22  
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5  
= ((10 * (6 / (12 * -11))) + 17) + 5  
= ((10 * (6 / -132)) + 17) + 5  
= ((10 * 0) + 17) + 5  
= (0 + 17) + 5  
= 17 + 5  
= 22

## Constraints

- 1 <= tokens.length <= 10^4
- tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

## Output

The evaluation of the given RPN

## Solution 1

About integer, we can push them to a stack because an arithmetic operator will be applied on the
last two integers. Because a token can contains a negative value from -200 to 200, we can convert it
by Integer.valueOf() or manually parse it with a sign.

About operator, we don't need to save it because it immediately applies on the last two integers.
And, a result of the operator will be pushed to the stack to be used on the next operator. 

When we evaluate all the tokes, the last integer in the stack is an evaluation of the given RPN.

A time complexity is O(n) because we need to check all the tokens.  
A space complexity is O(n) because we need to save all the integers in the given tokens.

- Time complexity: O(n)
- Space complexity: O(n)
