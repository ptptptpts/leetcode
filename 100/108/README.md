# Convert Sorted Array to Binary Search Tree

## Problem

Given an integer array `nums` where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

## Input

Integer array where the elements are sorted in ascending order

## Example

- Example 1:

>Input: nums = [-10,-3,0,5,9]  
Output: [0,-3,9,-10,null,5]  
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

- Example 2:

>Input: nums = [1,3]  
Output: [3,1]  
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

## Constraints

- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- nums is sorted in a strictly increasing order.

## Output

A root of a height balanced binary tree

## Solution 1

We can solve this problem by divide and conquer. If we have some sorted array, a root of
a balanced binary tree can be made by this array is a middle of a sorted array. After
then, we can assume its left and right child as a new binary tree can be made by its left
and right side array. We can repeat this until we traverse all the elements, and we can
make a balanced binary tree.

A time complexity is O(n) because we need to traverse all the elements in the array.  
A space complexity is O(log n) because the maximum depth of recursive call is depends on
a depth of a tree.

- Time complexity: O(n)
- Space complexity: O(log n)
