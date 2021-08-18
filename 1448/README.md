# Count Good Nodes in Binary Tree

## Problem

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

## Input

Root node of tree

## Example

Example 1:

```txt
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
```

Example 2:

```txt
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
```

Example 3:

```txt
Input: root = [1]
Output: 1
Explanation: Root is considered as good.
```

## Constraints

* The number of nodes in the binary tree is in the range [1, 10^5].
* Each node's value is between [-10^4, 10^4].

## Output

A number of good nodes in the input tree

## Solution 1

If the parent node is a good node, a child node will be a good node if it is larger or equal than the parent node. So, if we can convert the parent node as a good node, we can change this problem as the tree with only two layers, parent and child.

In this problem the root node is always a good node because it does not have any parents. So, after we change this problem as simple tree problem, we can assume the parent node is always a good node.

While traverse the input tree, if the child node is a good node, we can increase the counter and keep this value because it is a good node and it means it is the largest one in its tree.
In addition, if the child node is not a good node, we can keep the counter and change its value as the parent to make it as a good node for the next traversal.

The Time complexity is O(n), because we traverse the binary tree only once.

The Space complexity is O(n), because we need to save the parent nodes.

* Time complexity: O(n)
* Space complexity: O(n)
