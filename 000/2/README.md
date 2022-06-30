# Add Two Numbers

## Problem

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Input

Two linked lists that store two digits by reverse order.

## Example

- Example 1:

>Input: l1 = [2,4,3], l2 = [5,6,4]  
Output: [7,0,8]  
Explanation: 342 + 465 = 807.  

- Example 2:

>Input: l1 = [0], l2 = [0]  
Output: [0]  

- Example 3:

>Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]  
Output: [8,9,9,9,0,0,0,1]  

## Constraints

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

## Output

A linked list that contains a sum of two numbers in the given two linked lists by reverse order.

## Solution 1

This problem is a sum of two integers, so we can calculate it by moving a cursor from the start to end. And, if one of the lists ends first, we can assume it has a zero.

On each integer, we can calculate the sum of two integers s[i] by the below function.  

>s[i] = n[i] + m[i] + Round up from s[i-1]

A time complexity is O(max(l1.length, l2.length)), because we need to trace the given l1 and l2 linked list from start to end.  
A space complexity is O(max(l1.length, l2.length)), because a length of sum of two integers is max(l1.length, l2.length) or max(l1.length, l2.length) + 1.

- Time complexity: O(max(l1.length, l2.length))
- Space complexity: O(max(l1.length, l2.length))
