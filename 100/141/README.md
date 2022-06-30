# Linked List Cycle

## Problem

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

## Input

A head of linked list

## Example

- Example 1:

>Input: head = [3,2,0,-4], pos = 1  
Output: true  
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

- Example 2:

>Input: head = [1,2], pos = 0  
Output: true  
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

- Example 3:

>Input: head = [1], pos = -1  
Output: false  
Explanation: There is no cycle in the linked list.

## Constraints

- The number of the nodes in the list is in the range [0, 10^4].
- -10^5 <= Node.val <= 10^5
- pos is -1 or a valid index in the linked-list.

## Output

True if the linked list has a cycle in it.

## Solution 1

First, we can save all the visited node in the HashSet, and 
compare each next node is in there or not to find a cycle.  

In this case, a time complexity will be O(n) because we need to visit
all the nodes.  
And, a space complexity is O(n) because we need to save all the visited
nodes in a HashSet.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

The maximum length of the list is 10^4, so we can assume if any list
has longer than 10^4, this list has a cycle.  

In this case, a time complexity is O(n) because we always traverse the
list as the maximum length of the list.  
A space complexity is O(1) because we don't need to save any previous
nodes.

- Time complexity: O(n)  
- Space complexity: O(1)
