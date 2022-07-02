# Binary Tree Level Order Traversal

## Problem

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

## Input

Root of a binary tree

## Example

- Example 1:

>Input: root = [3,9,20,null,null,15,7]  
Output: [[3],[9,20],[15,7]]

- Example 2:

>Input: root = [1]  
Output: [[1]]

- Example 3:

>Input: root = []  
Output: []

## Constraints

- The number of nodes in the tree is in the range [0, 2000].
- -1000 <= Node.val <= 1000

## Output

List of Integer list that contains a list order traversal of the given
tree.

## Solution 1

Basically, it is based on a pre-order traversal, but we can traverse the
next level after finishing the current level. It means we need to make
a list to save a next level or a current level. On each level, we already
have a list of current level nodes and pop a node until it is empty. On
each node, we will write it in an integer list of a current level and
push all children to a list that contains next level nodes. When a
current list is empty, we can move to a next level list. If a next level
list is empty, we search all the nodes in the tree.

A time complexity is O(n) because we need to search all the nodes in the
tree.  
A space complexity is O(n) because the maximum number of nodes we can
save the list is depends on the number of nodes in the tree.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

From the Solution 1, if we have a current level on each node while using
a pre-order traversal, we don't need a list to divide a current level
with a next level because we can push a current value on a right
position. So, we can improve the previous solution to share a current
level when a traverse to the next level. It is based on a pre-order
traversal, but the only different is it shares a number of current level.

A time complexity is O(n) because we need to search all the nodes in the
tree.
A space complexity is O(n), but we don't need to save the nodes on each
level to a list.

- Time complexity: O(n)
- Space complexity: O(n)
