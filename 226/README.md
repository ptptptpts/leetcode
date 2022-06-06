# Invert Binary Tree

## Problem

Given the root of a binary tree, invert the tree, and return its root.

## Input

The root of a binary tree

## Example

- Example 1:

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

- Example 2:

Input: root = [2,1,3]
Output: [2,3,1]

- Example 3:

Input: root = []
Output: []

## Constraints

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

## Output

A root of a binary tree

## Solution 1

The given binary tree is already ordered, so we don't need to care about an order of it.  

To traverse the given tree, we can select a pre-order or post-order. In a pre-order, we'll inverse a
left and right of a root and recursively do the same thing on its child. And, in a post-order, we'll
inverse all the left and right children and inverse a left and right of a current node.

A time complexity is O(n) because we need to traverse all the nodes in the given array.  
A space complexity is O(1) because we don't save anything in memory.

- Time complexity: O(n)
- Space complexity: O(1)
