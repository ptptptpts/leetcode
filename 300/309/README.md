# Best Time to Buy and Sell Stock with Cooldown

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

- After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Input

Integer array that contains a stock price at each day.

## Example

- Example 1:

>Input: prices = [1,2,3,0,2]  
Output: 3  
Explanation: transactions = [buy, sell, cooldown, buy, sell]

- Example 2:

>Input: prices = [1]  
Output: 0

## Constraints

- 1 <= prices.length <= 5000
- 0 <= prices[i] <= 1000

## Output

The maximum profit we can archive from the given array with a cooldown.

## Solution 1

First, we can divide the problem as two state that finish with the maximum profit can be made by the last buy `b(i)` and finish with the maximum profit can be made by the last sell `s(i)`. And, we can represent the problem like this.

>b(i) = Max(b(i - 1), s(i - 2) - prices[i])  
s(i) = Max(s(i - 1), b(i - 1) + prices[i])

In this function, `b(i - 1)` means the last maximum profit that buy a stock at the cheapest price. `s(i - 2) - prices[i]` means a buy something after sell a stock and waiting a cooldown. `s(i - 1)` means the last maximum profit that sell a stock at the highest price. `b(i - 1) + prices[i]` means the profit that sell a stock by a current price. In additional, buying a stock always decrease a profit, so `s(n - 1)` will have the maximum profit can be made with a cooldown.

A time complexity is O(n) because we traverse the given array only once and compare it with the last two histories.  
A space complexity is O(1) because we save only the last maximum profit can be made at the last two days.

- Time complexity: O(n)
- Space complexity: O(1)
