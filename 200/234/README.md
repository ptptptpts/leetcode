# Palindrome Linked List

## Problem

Given the head of a singly linked list, return true if it is a palindrome.

## Input

Head of a singly linked list

## Example

- Example 1:

>Input: head = [1,2,2,1]  
Output: true

- Example 2:

>Input: head = [1,2]  
Output: false

## Constraints

- The number of nodes in the list is in the range [1, 10^5].
- 0 <= Node.val <= 9

## Output

True if it is a palindrome

## Solution 1

The input is a singly linked list, so we can't compare the input by backward normally.
But, if we can reverse the input at the middle of the list, we can compare on forward
and backward from its middle and find it is palindrome or not.

So, the first problem is how we find a middle of the list. We can find it by traverse
the given list with two cursors. The first one will move one node in each loop, and the
second one will move one node in each two loops. So, the second one will move a half of
the given list when the first one find the end of the list. And, we can reverse the list
when moving the second cursor to the next one, we can make the reversed list at the
middle of the list. Next, the second one will be in the middle of the list, and the first
half of the list is reversed and the next half of the list is in order. So, we can
compare each half and find the list is palindrome or not.

A time complexity is O(n) because we just traverse the given list twice to find a middle
of the list and compare each half.  
A space complexity is O(1) because we don't save any history and just reverse the given
list.

- Time complexity: O(n)
- Space complexity: O(1)
