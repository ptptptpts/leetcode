# Linked List Cycle

## Problem

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

## Input

Head of a linked list

## Example

Input: head = [3,2,0,-4], pos = 1  
Output: true  
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0  
Output: true  
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

## Constraints

- The number of the nodes in the list is in the range [0, 10^4].
- -10^5 <= Node.val <= 10^5
- pos is -1 or a valid index in the linked-list.

## Output

Return true if there is a cycle in the linked list. Otherwise, return false.

## Solution 1

Stupid but effective solution.

The maximum length of the list is 10^4. So, if we count a next node more than 10^4, the list is cycle.

The Time complexity is O(1), but always find 10^4 nodes.

The Space complexity is O(1) because it does not use any additional memories.

- Time complexity: O(sz)
- Space complexity: O(1)

## Solution 2

Brute force solution.

Trace the list with two cursors. The first one move to next node on every step, and the second one move the next-next node on every step. On every step, compare the both node and the list is cycle if they are same. If any cursor find a null node, the list is not a cycle.

The Time complexity is O(length) and it would not large than sum of a length of the list and cycle.

The Space complexity is O(1) because it does not use any additional memories.

- Time complexity: O(length)
- Space complexity: O(1)
