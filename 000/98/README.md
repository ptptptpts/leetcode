# Validate Binary Search Tree

## Problem

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.

## Input

A root of a binary tree.

## Example

- Example 1:

>Input: root = [2,1,3]  
Output: true

- Example 2:

>Input: root = [5,1,4,null,null,3,6]  
Output: false   
Explanation: The root node's value is 5 but its right child's value is 4.  

## Constraints

- The number of nodes in the tree is in the range [1, 10^4].
- -2^31 <= Node.val <= 2^31 - 1

## Output

True if the given binary tree is a valid BST.

## Solution 1

If some node satisfies conditions for a BST, it means the highest value
in its left subtree is less than a current node, and the lowest value in
its right subtree is higher than a current node. So, we can traverse all
the trees as a post-order traversal, and return the highest value if it
is a left subtree and the lowest value if it is a right subtree. And if
some subtree does not satisfy a condition for a BST, we can return the
maximum integer or minimum integer based on its callee.

At the second example, we'll find the maximum value of a left subtree of
`5` and the minimum value of a right subtree of `5`. Then, the left
subtree `1` does not have any child and return itself as the maximum
value. Then, the right subtree `4` has two children `3` and `6`. So, it
finds the maximum value of its left subtree and the minimum value of its
right subtree. Then, its left subtree `3` return itself as the maximum
value, and its right subtree `6` return itself as the minimum value. So,
the node `4` compare itself with the maximum value of its left subtree
and the minimum value of its right subtree, and it satisfies conditions
for BST because `4` is larger than `3` and smaller than `6`. Next, the
node `4` need to return the minimum value in itself and its subtrees, so
it need to return the minimum value of its left subtree. Therefore, its
left and right subtree should return the minimum and maximum value of
itself and its children. Then, the node `4` will return the minimum value
of its left subtree `3`, and the root node `5` finds it could not satisfy
a condition for a BST because it is higher than its right subtree `3`.

A time complexity is O(n) because we need to traverse all the nodes in
the given binary tree.  
A space complexity is O(1) because we save only the minimum and maximum
value of left and right subtree.

- Time complexity: O(n)
- Space complexity: O(1)
