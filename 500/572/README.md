# Subtree of Another Tree

## Problem

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in tree and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

## Input

Two root node of binary trees

## Example

- Example 1:

>Input: root = [3,4,5,1,2], subRoot = [4,1,2]  
Output: true

- Example 2:

>Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]  
Output: false

## Constraints

- The number of nodes in the root tree is in the range [1, 2000].  
- The number of nodes in the subRoot tree is in the range [1, 1000].  
- -10^4 <= root.val <= 10^4
- -10^4 <= subRoot.val <= 10^4

## Output

True if the second tree is a subtree of the first tree

## Solution 1

Even if the value of some node is same with a root of a subtree, it can't be a subtree
if a level of the node is different with a subtree. So, we can find a level of a subtree
first and use it to find a subtree from the first tree. Next, we can traverse the first
tree by a preorder traversal to compare a level of a current node. If a level and value
of current node is same with a root of the subtree, we can check this node is same with
the subtree or not.

A time complexity is O(n * m) because we need to compare the subtree from the first tree.  
A space complexity is O(log n) because we traverse the first tree by a preorder
traversal. 

- Time complexity: O(n * m)
- Space complexity: O(log n)
