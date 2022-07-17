# Same Tree

## Problem

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Input

Roots of two binary trees.

## Example

- Example 1:

>Input: p = [1,2,3], q = [1,2,3]  
Output: true

- Example 2:

>Input: p = [1,2], q = [1,null,2]  
Output: false

- Example 3:

>Input: p = [1,2,1], q = [1,1,2]  
Output: false

## Constraints

- The number of nodes in both trees is in the range [0, 100].
- -10^4 <= Node.val <= 10^4

## Output

True if two binary trees are same

## Solution 1

We can traverse both trees together by a post-order traversal. And if a current node is
same and both of them has no child, it can return a true. Next, if both left and right
child return true, this traversal can return true.  

For example, when a traversal() is called, we need to compare a value of a current node
first. If they are different, this method will return false. Next, if both of them has a
left child, we'll call a traversal() again on a left child. If one of them does not have
a left child, we can return false. If both of them does not have a left child, we can
skip a left child and assume a traversal() return true on a left child. We can do the
same thing on a right child. If one of a traversal() on a left and right child return
false, a current traversal() return false.  

A time complexity is O(n) because we need to compare all the nodes in both trees.  
A space complexity is O(1) because we don't save the previous histories in a memory.

- Time complexity: O(n)
- Space complexity: O(1)
