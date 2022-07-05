# Reverse Linked List

## Problem

Given the head of a singly linked list, reverse the list, and return the reversed list.

## Input

A head of a singly linked list

## Example

- Example 1:

>Input: head = [1,2,3,4,5]  
Output: [5,4,3,2,1]

- Example 2:

>Input: head = [1,2]  
Output: [2,1]

- Example 3:

>Input: head = []  
Output: []

## Constraints

- The number of nodes in the list is the range [0, 5000].
- -5000 <= Node.val <= 5000

## Output

A head of the reversed singly linked list

## Solution 1

If the node `a` has a node `b` as its next, we can reverse it by
connecting the node `b` to the node `a`. While reverse two nodes, we can
save a next of the node `b` as a variable. So, we can reverse the list
by saving a previous, current, and next node as a variable.

A time complexity is O(n) because we need to traverse a list at least
once.  
A space complexity is O(1) because we save only three nodes while
traversing the list.

- Time complexity: O(n)
- Space complexity: O(1)
