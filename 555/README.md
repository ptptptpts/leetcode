# Maximum Depth of Binary Tree

## Problem

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Input

Root of TreeNode

## Example

Input: root = [3,9,20,null,null,15,7]  
Output: 3

Input: root = [1,null,2]  
Output: 2

## Constraints

- The number of nodes in the tree is in the range [0, 104].
- -100 <= Node.val <= 100

## Output

Maximum depth of tree

## Solution 1

To find maximum depth of binary tree, we need to trace all nodes in Tree.

First, if the node is null, we can assume a length of this node is '0'.  
Second, if the node is not null, we can assume a length of this node is (length of child) + 1.
Third, we can select a longer one between left and right childs when find a length of current node.

The Time complexity is O(Number of nodes) because we need to trace all the nodes in tree.

The Space complexity is O(1) because we don't use any additional memory.

- Time complexity: O(Number of nodes)
- Space complexity: O(1)
