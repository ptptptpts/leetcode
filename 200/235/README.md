# Lowest Common Ancestor of a Binary Search Tree

## Problem

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

## Input

Root, p, and q of the binary search tree.

## Example

- Example 1:

>Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8  
Output: 6  
Explanation: The LCA of nodes 2 and 8 is 6.  

- Example 2:

>Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4  
Output: 2  
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.  

- Example 3:

>Input: root = [2,1], p = 2, q = 1  
Output: 2

## Constraints

- The number of nodes in the tree is in the range [2, 10^5].
- -10^9 <= Node.val <= 10^9
- All Node.val are unique.
- p != q
- p and q will exist in the BST.

## Output

The lowest common ancestor of p and q node.

## Solution 1

A size of the tree is smaller than 10^5. It means we can find any node in the tree
in log(10^5) time cost, and also it means we can find any node in 18 times to compare
a node with the value we want to find. So, it is okay to find a node p and node q from
the root and find their common ancestor.  

A common ancestor means two loop will meet together in the same level of a tree.
So, we can record to route to find each node p and q, and compare them to find a
common ancestor. Because all the nodes have a unique value, we can find a common
ancestor if both route contains the same value in the same level.

A time complexity is O(logN) if N means a size of the tree, because we find the node p and q from the given tree.  
A space complexity is O(logN) because we record the route to find a node p and q.

- Time complexity: O(logN)
- Space complexity: O(logN)
