# Maximum Depth of Binary Tree

## Problem

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Input

A root of the binary tree

## Example

- Example 1:

>Input: root = [3,9,20,null,null,15,7]  
Output: 3

- Example 2:

>Input: root = [1,null,2]  
Output: 2

## Constraints

- The number of nodes in the tree is in the range [0, 10^4].
- -100 <= Node.val <= 100

## Output

The maximum depth of the binary tree

## Solution 1

We'll traverse the array by post-order traversal, and each child will
return a depth of itself. After getting a depth of each node, a current
node will return a higher depth + 1 value. If a current node does not
have any child, it will return 1.  

A time complexity is O(n) because we will traverse all the nodes in the
given binary tree.  
A space complexity is O(1) because we don't save the previous history in
the memory.

- Time complexity: O(n)
- Space complexity: O(1)
