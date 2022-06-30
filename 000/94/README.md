# Binary Tree Inorder Traversal

## Problem

Given the root of a binary tree, return the inorder traversal of its nodes' values.

## Input

A root of a binary tree

## Example

- Example 1:

>Input: root = [1,null,2,3]  
Output: [1,3,2]  

- Example 2:

>Input: root = []  
Output: []

- Example 3:

>Input: root = [1]  
Output: [1]

## Constraints

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

## Output

Integer list that contains a result of inorder traversal.

## Solution 1

Recursive solution. In traversal() method, call itself with a left of a node, add a value of a node to a list, and call itself with a right of a node. If a node is null, return immediately.  

A time complexity is O(n) because we need to traverse all the items in the tree.  
A space complexity is O(n) because we need to call traversal() method as a size of the given binary tree if the tree consists of a list. And it saves all the values to a List.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Iterative solution. Push the root node in a stack and do the follow things until a stack is empty.

1) Peek a top node
2) If a left of the top node is not null, push it to a stack, change a left of the previous top node as null, and go to 1st step.
3) If a left of the top node is null, pop the top node, add its value to a list, and push the right node to a stack if it is not null. And go to the 1st step.

A time and space complexity is same with the solution 1.

## Solution 3

Iterative solution, but does not change a node. We need to find a left of a node at the top of the stack only. So, save a top node as a variable instead of a stack, and a stack saves only nodes that need to check its value and right. Then, a logic on the solution 2 is changed like this.  

0) Save a root as a top node.
1) If a top node exist, push a top node to a stack.
   If a top node has a left, save a left as a top node and return to the 1st step.  
   If a top node does not have a left, change a top node as null.
2) If a stack is empty, finish this logic.
3) Pop a node from a stack, and push its value to a list.  
   If a node has a right, save it as a top node and return to the 1st step.  
   If a node does not have a right, return to the 2nd step.

A time and space complexity is same with the solution 1.
