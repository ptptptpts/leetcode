# Best Time to Buy and Sell Stock

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Input

Integer array that contains a price of stock on each day

## Example

- Example 1:

>Input: prices = [7,1,5,3,6,4]  
Output: 5  
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.  
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

- Example 2:

>Input: prices = [7,6,4,3,1]  
Output: 0  
Explanation: In this case, no transactions are done and the max profit = 0.

## Constraints

- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

## Output

The maximum profit you can archive from a single transaction

## Solution 1

From the given array, we can buy a stock at the `i` th day and sell it at the `j` th day of future. It means `i` should be smaller than `j`. So, we can hold the cheapest price until a current day `n` and assume we can sell it at today `n`. If it is the maximum profit, we can hold it as the current maximum profit. After we traverse the given array, the current maximum profit is the maximum profit of the given array.  

A time complexity is O(n) because we need to traverse the array at least once.  
A space complexity is O(1) because we save only the maximum profit.

- Time complexity: O(n)
- Space complexity: O(1)
