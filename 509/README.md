# Fibonacci Number

## Problem

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

>F(0) = 0, F(1) = 1  
F(n) = F(n - 1) + F(n - 2), for n > 1.  

Given n, calculate F(n).  

## Input

Integer N

## Example

Example 1:  
Input: n = 2  
Output: 1  
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.  

Example 2:  
Input: n = 3  
Output: 2  
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.  

Example 3:  
Input: n = 4  
Output: 3  
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.  

## Constraints

0 <= n <= 30

## Output

Nth fibonacci number

## Solution 1

Nth fibonacci number can be calculated by sum of N-1th and N-2nd fibonacci numbers. So, if the number N is given, we can simply calculate the Nth fibonacci number by loop 2 to N.  

A time complexity is O(n) because we calculate from 1 to N.  
A space complexity is O(1) because we don't save a number in memory.

- Time complexity: O(N)
- Space complexity: O(1)
