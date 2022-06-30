# Integer Break

## Problem

Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.

## Input

Integer n

## Example

- Example 1:

>Input: n = 2  
Output: 1  
Explanation: 2 = 1 + 1, 1 × 1 = 1.

- Example 2:

>Input: n = 10  
Output: 36  
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

## Constraints

- 2 <= n <= 58

## Output

The maximal product can be made the sum of k positive integers that can made an integer n by their sum.

## Solution 1

Let's assume we already have the maximal product `f(n)` until the integer `n`. Then, we can assume we already find all the combinations can make the integers until `n-1`. So, all the combinations that make the integer `n` is new one.  
Then, to find the maximum product at the integer `f(n)`, we can compare all the product `f(i) * (n - i)` and select the maximum one as the maximum product. But, at the given integer n, it should use at least two integers to make a product. So, it could not make itself as the maximum product. However, if `n` is not the given integer n, it can use itself as the maximum product to because any larger integer will product something on there.

A time complexity is O(n^2) because we traverse all the previous histories to find the maximal product on each integer.  
A space complexity is O(n) because we need to save all the previous maximal product on each integer.

- Time complexity: O(n^2)
- Space complexity: O(n)
