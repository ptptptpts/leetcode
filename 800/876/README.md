# Middle of the Linked List

## Problem

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

## Input

A head of a singly linked list

## Example

- Example 1:

>Input: head = [1,2,3,4,5]  
Output: [3,4,5]  
Explanation: The middle node of the list is node 3.  

- Example 2:

>Input: head = [1,2,3,4,5,6]  
Output: [4,5,6]  
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

## Constraints

- The number of nodes in the list is in the range [1, 100].
- 1 <= Node.val <= 100

## Output

The middle node of the linked list.

## Solution 1

We can use two cursors to traverse the given singly linked list. The
first cursor will move one node at each loop, and the second cursor will
move one node at each two loop. So, the second cursor will move a half
of the first cursor, and it will point a middle of the list when the
first cursor find the end of the given linked list.

Let's assume the given linked list has an odd number of nodes. Then two
cursors will be in the below position when the first cursor find the end
of the list.

List|0|1|2|3|4 
---|---|---|---|---|---
First|.|.|.|.|*
Second|.|.|*

So, we can use the second cursor as itself if a number of nodes in the
given linked list is odd.

Let's assume a number of the given linked list is even.

List|0|1|2|3|4|5
---|---|---|---|---|---|---
First|.|.|.|.|.|*
Second|.|.|*

In this case, the second cursor is behind of the node we want to return.
So, we need to return a next of a second cursor when a number of nodes
of the given linked list is even.

A time complexity is O(n) because we need to traverse all the node of
the given linked list.  
A space complexity is O(1) because we only store two cursors.

- Time complexity: O(n)
- Space complexity: O(1)
