# Coin Change

## Problem

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

## Input

Integer array that contains a price of coin, and total amount of money

## Example

- Example 1:

>Input: coins = [1,2,5], amount = 11  
Output: 3  
Explanation: 11 = 5 + 5 + 1

- Example 2:

>Input: coins = [2], amount = 3  
Output: -1

- Example 3:

>Input: coins = [1], amount = 0  
Output: 0

## Constraints

- 1 <= coins.length <= 12
- 1 <= coins[i] <= 2^31 - 1
- 0 <= amount <= 10^4

## Output

The fewest number of coins that can make the given amount of money by the given coins

## Solution 1

If we have the fewest number of coins `f(a)` at the amount `a` and have a coin `b`, the fewest number of coins `f(a + b)` at the amount `a + b` is `f(a+b) = f(a) + 1` because it just add a coin from the amount `a`.  
So, if we have all the fewest number of coins until `a` and have a coin `b`, the fewest number of coins at the amount `a + 1` is `f(a+1) = f(a+1-b) + 1` if `f(a+1-b)` is not zero. And, if we have multiple coins, we can find the fewest number of coins by find all the fewest number of coins with all the coins and select the fewest one.

A size of coins array is `n`, and amount is `m`.
A time complexity is O(n * m), because we make the fewest number of coins in each price and need to traverse the coins array on each price.  
A space complexity is O(m), because we need to save the fewest number of coins in each price.

- Time complexity: O(n * m)
- Space complexity: O(m)
