# Balanced Binary Tree

## Problem

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

## Input

A root node of a binary tree

## Example

- Example 1:

>Input: root = [3,9,20,null,null,15,7]  
Output: true

- Example 2:

>Input: root = [1,2,2,3,3,null,null,4,4]  
Output: false

- Example 3:

>Input: root = []  
Output: true

## Constraints

- The number of nodes in the tree is in the range [0, 5000].
- -10^4 <= Node.val <= 10^4

## Output

True if a tree is height-balanced.

## Solution 1

The maximum number of nodes is 5000, so a length of the longest node
is 5000 in the worst case. And it is enough to check a height-balanced
tree in all the nodes.

To find this node is height-balanced or not, we need to search all the
left and right child nodes of a current node. It means we need to
traverse the tree as post-order traversal.  

And we'll traverse the tree recursively, and return a length of current
node on each call. Then, each node will find a length of left and right
child and can find this node is height-balanced or not by comparing them.
And, it can return its length by adding 1 on a longer length. If a
current node is not height-balanced, we can return -1 to mark this tree
is not height-balanced.

A time complexity is O(n) because we need to traverse all the nodes in
the given tree.  
A space complexity is O(n) because we traverse the tree recursively,
and it means each call takes a memory on the stack.

- Time complexity: O(n)
- Space complexity: O(n)
