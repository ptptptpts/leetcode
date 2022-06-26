# Remove Nth Node From End of List

## Problem

Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Input

A head of the linked list, and a number of node what we need to delete from the end of the list. 

## Example

- Example 1:

>Input: head = [1,2,3,4,5], n = 2  
Output: [1,2,3,5]

- Example 2:

>Input: head = [1], n = 1  
Output: []

- Example 3:

>Input: head = [1,2], n = 1  
Output: [1]

## Constraints

- The number of nodes in the list is sz.
- 1 <= sz <= 30
- 0 <= Node.val <= 100
- 1 <= n <= sz

## Output

A head of the linked list.

## Solution 1

To find the n-th node from the end of list, we can use two cursors. One
node leads the n-th node from the others. This node will use to find the
end of the list. The other cursor starts from the head, and it is used
to find the node what we want to delete.  

The first cursor starts at the n-th node from the start, and the second
node starts from the head node. On each loop, both two nodes moves to the
next one. And, when the first node meet the last node of the list, the
second node will point the n-th node from the end because it is behinds
of the n-th node from the first one.

A time complexity is O(n) because we need to traverse all the nodes in
the list.  
A space complexity is O(1) because we always save only two nodes.  

- Time complexity: O(n)
- Space complexity: O(1)
