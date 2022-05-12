# Fizz Buzz

## Problem

Given an integer n, return a string array answer (1-indexed) where:

- answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
- answer[i] == "Fizz" if i is divisible by 3.
- answer[i] == "Buzz" if i is divisible by 5.
- answer[i] == i (as a string) if none of the above conditions are true.

## Input

Integer n that the last number of FizzBuzz

## Example

- Example 1:

>Input: n = 3  
Output: ["1","2","Fizz"]  

- Example 2:

>Input: n = 5  
Output: ["1","2","Fizz","4","Buzz"]  

- Example 3:

>Input: n = 15  
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

## Constraints

- 1 <= n <= 10^4

## Output

List that contains all FizzBuzz from 1 to the given n

## Solution 1

FizzBuzz is simple because we can find a FizzBuzz of `i`th integer by finding modular of 15, 5, 3. If a number is divided by 15, it is `FizzBuzz`. If a number is divided by 3, it is `Fizz`. If a number is divided by 5, it is `Buzz`. If a number is non of them, it is as itself. So, a FizzBuzz of each integer can be found by four if statements.  

A time complexity is O(n) because we need to traverse from 1 to n to find a FizzBuff of each integer.  
A space complexity is O(n) because we need to save a FizzBuzz of each integer from 1 to n.

- Time complexity: O(n)
- Space complexity: O(n)
