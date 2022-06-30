# Binary Tree Level Order Traversal

## Problem

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

## Input

Root node of tree

## Example

Input: root = [3,9,20,null,null,15,7]  
Output: [[3],[9,20],[15,7]]

Input: root = [1]  
Output: [[1]]

Input: root = []  
Output: []

## Constraints

- The number of nodes in the tree is in the range [0, 2000].
- -1000 <= Node.val <= 1000

## Output

List of Integer List. Each Integer List contains all nodes in each level from left to right.

## Solution 1

Traverse a tree by post-order with counting a current level. Put each node to a current level of integer list.

The Time complexity is O(n) because it traverse all the nodes in a tree.

The Space complexity is O(n) because it saves all the nodes to a list.

- Time complexity: O(n)
- Space complexity: O(n)
