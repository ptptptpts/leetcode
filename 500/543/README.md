# Diameter of Binary Tree

## Problem

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

## Input

Root of a binary tree

## Example

- Example 1:

>Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

- Example 2:

>Input: root = [1,2]  
Output: 1

## Constraints

- The number of nodes in the tree is in the range [1, 10^4].
- -100 <= Node.val <= 100

## Output

A length of the diameter of the tree

## Solution 1

A length of the diameter on each node is sum of a length of its left and
right child. So, we need to check a diameter of each node to find the
longest diameter because the longest diameter may not contain the root.
On each recursive, it will check the longest diameter and return a
longest length of its child.

A time complexity is O(n) because we need to traverse all the nodes int
the tree.  
A space complexity is O(1) because we return the longest path on each
node.

- Time complexity: O(n)
- Space complexity: O(1)
