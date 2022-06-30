# Unique Binary Search Trees

## Problem

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

## Input

A size of binary tree

## Example

- Example 1:

>Input: n = 3  
Output: 5

- Example 2:

>Input: n = 1  
Output: 1

## Constraints

- 1 <= n <= 19

## Output

A number of unique binary search trees with the given size `n`

## Solution 1

If we define a number of unique binary search trees with the size `n`, we can find it by sum of binary trees with a root `1` to `n` because it is a unique binary tree if they have a different root. And a binary tree with a size `n` and root `k` will have a left child with a size `k-1` and a right child with a size `n-k`. Then we can describe it as a function `g(n)` and `f(k, n)`.

```bash
g(n) = a number of unique binary trees with a size n
f(k, n) = a number of unique binary trees with a size n and root k
g(n) = f(1, n) + f(2, n) + f(3, n) + ... + f(n-1, n) + f(n, n)
f(k, n) = g(k-1) * g(n-k)
```

Then, we have a g(1) as 1, so we can calculate g(n) from g(1).  

A time complexity is O(n^2) because we need to find from g(1) to g(n), and each g(k) is a sum of g(1) to g(k-1).  
A space complexity is O(n) because we need to save all a number of unique binary trees.

- Time complexity: O(n^2)
- Space complexity: O(n)
