# Reverse Linked List II

## Problem

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

## Input

The head of a singly linked list and two integers left and right.

## Example

Example 1:  
Input: head = [1,2,3,4,5], left = 2, right = 4  
Output: [1,4,3,2,5]

Example 2:  
Input: head = [5], left = 1, right = 1  
Output: [5]

## Constraints

- The number of nodes in the list is n.
- 1 <= n <= 500
- -500 <= Node.val <= 500
- 1 <= left <= right <= n

## Output

The head of a reversed singly linked list.

## Solution 1

Store the nodes that need to reverse to the array and swap the value of the nodes.

The Time complexity is O(n + right - left), because it trace whole the array at least once to find left and right, and trace once again from left to right to swap the value.

The Space complexity is O(right - left), because it saves nodes from left to right in array.

- Time complexity: O(n + (right - left))
- Space complexity: O(right - left)

## Solution 2

In singly linked list node, we can reverse nodes from left to right by the below two steps.

Original: 1 -> 2 -> 3 -> 4 -> 5, left 2, right 4

Step 1: Reverse nodes from left to right

Step 1 Result: 1 -> (2 <- 3 <- 4) -> 5

Step 2: Connect left-1 th node to right, and left to right+1 th node

Final: 1 -> 4 -> 3 -> 2 -> 5

In this case, we need to store left-1, left, right, and right+1 th nodes.  
Moreover, we don't need to traverse a list again from left to right.

The Time complexity is O(n), because we reverse the nodes while we traverse the list.

The Space complexity is O(1), because we saves only left-1, left, right, and right+1 th nodes.

- Time complexity: O(n)
- Space complexity: O(1)
