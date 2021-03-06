# Best Time to Buy and Sell Stock

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Input

Integer array that describes a stock price at each day.

## Constraints

- 1 <= prices.length <= 105
- 0 <= prices[i] <= 104

## Output

Maximum profit you can achive from this single buy-sell transaction.

## Solution

The basic strategy is buying a stock on the minimum price and selling it on the maximum price.  
To find the maximum profit of n th day, we can find it from comparing the maximum profit of n-1 th day and the profit of n th day.  
If the profit of n th day is larger than n-1 th day, we can assume it as the maximum profit of n th day.

Let's assume the input is [7,1,5,3,6,4].

On the first day, we have the price only [7], and the minimum price is 7.  
On the Second day, we have the price [7,1], and the minimum price is 1 and can't make any profit.  
On the third day, we have the price [7,1,5], and the minimum price is 1 and can make the profit 4 on 3rd day. So, the maximum profit is 4.  
On the fourth day, we have the price [7,1,5,3], and the minimum price is 1 and can make the profit 2 on 4th day. So, the maximum profit is still 4.  
On the fifth day, we have the price [7,1,5,3,6], and the minimum price is 1 and can make the profit 5 on 5th day. So, the maximum profit is updated to 5.  
On the fifth day, we have the price [7,1,5,3,6,4], and the minimum price is 1 and can make the profit 3 on 6th day. So, the maximum profit is still 5.  

A time complexity is O(n) because we need to track the entire given integer array.  
A space complexity is O(1) because we need to save only the minimum price and the current maximum profit.

- Time complexity: O(n)
- Space complexity: O(1)

## For Best Performance

1) If the price is same or less than the minimum price, we don't need to check the maximum profit because we can't make any profit on this day.
