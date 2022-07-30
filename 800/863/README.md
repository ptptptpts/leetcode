# All Nodes Distance K in Binary Tree

## Problem

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

## Input

A root of a binary tree, a target node, and distance k

## Example

- Example 1:

>Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2  
Output: [7,4,1]  
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.  

- Example 2:

>Input: root = [1], target = 1, k = 3  
Output: []

## Constraints

- The number of nodes in the tree is in the range [1, 500].
- 0 <= Node.val <= 500
- All the values Node.val are unique.
- target is the value of one of the nodes in the tree.
- 0 <= k <= 1000

## Output

A list of node that have a distance k from the target node.

## Solution 1

First, we need to find the target node by a pre-order traversal to find the target node
first. Next, if we find the target node, we can find all the nodes in the distance k from
its child first. Next, we can return a distance from the target node in return, and
traverse the array again to find the node with a distance k.

In each loop, we can compare the current node with the target node if we can't find the
target node yet. If a current node is not the target node, we can move to its child. If
a current node is the target node, we can change the node to find all the nodes in a
distance k from the target node.

To find a node with a distance k from the target node, we need to check a distance from
the target node in a current node. We can find it by sending it via a parameter and
return of a recursive method. If we can't find the target node yet, we can return a
distance as -1.

A time complexity is O(n) because we traverse the array twice in the worst case.  
A space complexity is O(n) because we need to traverse the array recursively.

- Time complexity: O(n)
- Space complexity: O(n)
