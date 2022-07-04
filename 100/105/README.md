# Construct Binary Tree from Preorder and Inorder Traversal

## Problem

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

## Input

Two integer arrays preorder and inorder of the same binary tree

## Example

- Example 1:

>Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]  
Output: [3,9,20,null,null,15,7]

- Example 2:

>Input: preorder = [-1], inorder = [-1]  
Output: [-1]

## Constraints

- 1 <= preorder.length <= 3000
- inorder.length == preorder.length
- -3000 <= preorder[i], inorder[i] <= 3000
- preorder and inorder consist of unique values.
- Each value of inorder also appears in preorder.
- preorder is guaranteed to be the preorder traversal of the tree.
- inorder is guaranteed to be the inorder traversal of the tree.

## Output

The binary tree can build the same preorder and inorder with the input

## Solution 1

In inorder, all the values in the left of `i` is located in the left of
`i` in a binary tree, and it can be applied by the same way in the right
of `i`. In preorder, basically it shows a node in a higher level first.
For example, it always starts from a root of a binary tree.

So, we can use a preorder array to build a binary tree from a root to
end, and we can use an inorder tree to find its next value in a
preorder is left or right child. From the example 1, we can start from
the first integer of a preorder `3`. Next we can find its next value `9`
from an inorder tree. Because `9` is left of a `3`, we can find a `9` is
a left child of the `3`. In the other side, `20` is a right side of the
`9`, but it is not between `9` and `3`. It means this `20` is not a child
of `9`, we can find this value is a right child of the `3`. Next, `15`
is in between `3` and `20`, we can find it is a left child of the `20`.
And `7` is right of `15`, we can find it is a right child of the `15`.

In conclusion, we need a start and end position in an inorder array, and
we need to find a position of a current character in a preorder from an
inorder array. If a position of a current character is a left of starting
position, this node is not a child of a current character. We can apply
the same thing on a right of end position. If a position of a current
character is in between a starting position and its parent, it will be
a left child of a parent. We can apply the same thing in its end
position and right child.

A time complexity is O(n), because we can use a HashMap to find a
location in an inorder array. In this case, we can find a position of
a current number in O(1) cost, so only the cost in a preorder O(n) is
remained.  
A space complexity is O(n), because we will save a location of all nodes
in an inorder tree in a HashMap.

- Time complexity: O(n)
- Space complexity: O(n)
