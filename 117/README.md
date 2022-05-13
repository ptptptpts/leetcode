# Populating Next Right Pointers in Each Node II

## Problem

Given a binary tree

>struct Node {  
  int val;  
  Node *left;  
  Node *right;  
  Node *next;  
}  

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

## Input

A head of a binary tree and a next of all the nodes are set as null.

## Example

- Example 1:

>Input: root = [1,2,3,4,5,null,7]  
Output: [1,#,2,3,#,4,5,7,#]  
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.  

- Example 2:

>Input: root = []  
Output: []

## Constraints

- The number of nodes in the tree is in the range [0, 6000].
- -100 <= Node.val <= 100

## Output

A head of a binary tree and a next of all the nodes should point a next right node in a binary tree.

## Solution 1

We can traverse the given array and save each layer of the given tree in another array list. This array list contains all the nodes in the given array by layer-order, and each layer is divided by null object.  
After building the array list, we can traverse this array and connect each node to the next one because this array contains nodes from left to right order.

A time complexity is O(n) because we need to traverse the given array once to build an array list.  
A space complexity is O(n) because we save entire items in an array list.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Let's assume we already connect one of the layer of the given array. Then, we can traverse all the next layers by traverse all the child nodes of a current layer. And also we can connect them by holding a previous child node and connect it a next child node.  
Next, let's return back to a root of the given array. A root node is already fully connected itself because the first layer of each binary tree has only one node root.  
So, we can start to connect a child layer from the given root and connect all the layers.

A time complexity is O(n) because we need to traverse the given array at least once.  
A space complexity is O(1) because we don't save anything in an outside of the given nodes.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 3

Start from the solution 1, but we can point a next of each node when we collect a next layer of the given tree. For example, if we save the previous node of a next layer, we can connect it to a node what we found for a next layer. And then, we can grant a next layer as already connected by its next field, so we don't need to use an array to save a current or next layer like the 2nd solution.

A time complexity is O(n) because we need to traverse the given array at least once.  
A space complexity is O(1) because we don't save anything in an outside of the given nodes.

- Time complexity: O(n)
- Space complexity: O(1)
