# Convert Sorted Array to Binary Search Tree

## Problem

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

## Input

Sorted integer array

## Example

Input: nums = [-10,-3,0,5,9]  
Output: [0,-3,9,-10,null,5]  
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Input: nums = [1,3]  
Output: [3,1]  
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.

## Constraints

- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- nums is sorted in a strictly increasing order.

## Output

Root of height-balanced binary serch tree

## Solution 1

Let's assuem the length of array is n. If this array is a height-balanced BST, the middle of this array will be a root.  
And a root of the left array will be a left leaf and a root of the right array will be a right leaf.  

The Time complexity is O(n), because it trace all the items in array.

The Space complexity is O(n), because it make all the items in array to Tree node.

- Time complexity: O(n)
- Space complexity: O(n)
