# N-th Tribonacci Number

## Problem

The Tribonacci sequence Tn is defined as follows:  

> T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

## Input

Integer N

## Example

- Example 1:

>Input: n = 4  
Output: 4  
Explanation:  
T_3 = 0 + 1 + 1 = 2  
T_4 = 1 + 1 + 2 = 4  

- Example 2:

>Input: n = 25  
Output: 1389537

## Constraints

- 0 <= n <= 37
- The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

## Output

Nth tribonacci number

## Solution 1

Same with the Fibonacci number problem, it can be calculated as saving the last 3 tribonacci numbers.  

A time complexity is O(n) because we calculate the Nth tribonacci number from 1 to N.  
A space complexity is O(1) because we don't save anything in memory.

- Time complexity: O(n)
- Space complexity: O(1)
