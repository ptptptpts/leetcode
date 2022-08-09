# Palindrome Number

## Problem

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.

## Input

Integer x

## Example

- Example 1:

>Input: x = 121  
Output: true  
Explanation: 121 reads as 121 from left to right and from right to left.

- Example 2:

>Input: x = -121  
Output: false  
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.  

- Example 3:

>Input: x = 10  
Output: false  
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

## Constraints

- -2^31 <= x <= 2^31 - 1
- Follow up: Could you solve it without converting the integer to a string?

## Output

True if the given integer x is a palindrome.

## Solution 1

First, if the given integer x is a negative, it is not a palindrome due to '-'
character. So, we don't need to care about a palindrome in a negative integer.
Next, if the given integer x is a palindrome, it is same even if we reverse the given
integer. It means, it is same with its reverse. So, we can make a reverse of the given
integer x, and find it is palindrome or not by comparing the reverse with the original
integer x.

A time complexity is O(log10(n)) because we need to divide the given integer x to make
a reverse of it.  
A space complexity is O(1) because we just use a reverse of the integer x.

- Time complexity: O(log10(n))
- Space complexity: O(1)
