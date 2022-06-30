# Best Time to Buy and Sell Stock II

## Problem

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

## Input

Integer array that contains a price of stock at each day.

## Example

- Example 1:

>Input: prices = [7,1,5,3,6,4]  
Output: 7  
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.  
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.  

- Example 2:

>Input: prices = [1,2,3,4,5]  
Output: 4  
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.  
Total profit is 4.  

- Example 3:

>Input: prices = [7,6,4,3,1]  
Output: 0  
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

## Constraints

- 1 <= prices.length <= 3 * 10^4
- 0 <= prices[i] <= 10^4

## Output

The maximum profit you can get from the given array.

## Solution 1

There are no limit to buy or sell a stock on each day in this problem. So, on each day, we can get a profit if a price is higher than yesterday. And we'll loss a money if a price is lower than yesterday. Therefore, if we get all the profits from the array and lost no money, we'll get the maximum profit.

On each day, we can compare a price with yesterday. And we assume that we already bought it yesterday and sell it on today if a today's price is higher. If a today's price is lower, we can assume we didn't buy a stock at yesterday.  

A time complexity is O(n) because we need to traverse the array and compare each price with a yesterday.  
A space complexity is O(1) because we don't save anything on each day and just collect a profit on each day.

- Time complexity: O(n)
- Space complexity: O(1)
