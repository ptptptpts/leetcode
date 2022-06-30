# Symmetric Tree

## Problem

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## Input

A root of a binary tree.

## Example

- Example 1:

>Input: root = [1,2,2,3,4,4,3]  
Output: true

- Example 2:

>Input: root = [1,2,2,null,3,null,3]  
Output: false

## Constraints

- The number of nodes in the tree is in the range [1, 1000].
- -100 <= Node.val <= 100

## Output

True if a binary tree is a mirror of itself.

## Solution 1

Recursive solution. Make a compareLeftRight() method and compare a left and right side by a pre-order. A compareLeftRight() method compare itself first, and call itself again with its child if they are same.

A time complexity is O(n) because we need to traverse all the nodes in the tree in the worst case.  
A space complexity is O(n) because this method can be called a number of all the nodes in the tree in the worst case.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Iterative solution. Save a node to compare at the next in a stack and compare them. Basically, we can use two stacks for a left and right side, but we can merge them in to a stack by push and pop two nodes.

A time and space complexity are same with the solution 1.
