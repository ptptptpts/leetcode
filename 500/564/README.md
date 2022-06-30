# Best Time to Buy and Sell Stock II

## Problem

Find the maximum profit from the given stock price array.  
Each day you can buy or sell one stock, but can't engage in multiple transactions at the same day.  
And, you can buy or sell only one stock.  

## Input

Integer array that describe a stock price on each day.

## Constraints

- 1 <= prices.length <= 3 * 10 ^ 4
- 0 <= prices[i] <= 10 ^ 4

## Output

Return the maximum profit.

## Solution 1

Find maximum and minimum local peak.  
And buy a stock at each minumum peak and sell it at each next maximum peak.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2 (Improve the Solution 1)

Let's assume we can buy and sell one stock in the same day.  
Because we buy and sell a stock at the same price, it is same with that not buying anything.  
On each day, if a price is higher than yesterday, we can assume we already bought a stock on yesterday and make a profit on today by selling and buying a stock.  
And, if a price is lower or same with yesterday, we can assume we did not buy a tock on yesterday.  
By repeating this, we can find a sum of all the difference between all local minimum and maximum peak.

- Time complexity: O(n)
- Space complexity: O(1)
