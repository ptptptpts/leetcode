# Best Time to Buy and Sell Stock with Transaction Fee

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

## Input

Integer array that contains a price of stock on each day, and a transaction fee

## Example

- Example 1:

>Input: prices = [1,3,2,8,4,9], fee = 2  
Output: 8  
Explanation: The maximum profit can be achieved by:  
>
>- Buying at prices[0] = 1  
>- Selling at prices[3] = 8  
>- Buying at prices[4] = 4  
>- Selling at prices[5] = 9  
>
>The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.  

- Example 2:

>Input: prices = [1,3,7,5,10,3], fee = 3  
Output: 6

## Constraints

- 1 <= prices.length <= 5 * 10^4
- 1 <= prices[i] < 5 * 10^4
- 0 <= fee < 5 * 10^4

## Output

The maximum profit we can archive.

## Solution 1

We have a two state on each day that `buy` or `sell` a stock. Because we can have only one stock in time, we can move to a `sell` state from `buy` and to `buy` state from `sell` state.  
Then, we can find the maximum profit on `buy` and `sell` state on each day by the below function.

>maxBuy(i) = Max(maxBuy(i-1), buy(i))  
>maxSell(i) = Max(maxSell(i-1), sell(i))

And, as we found before, we can move to `buy` from `sell`, and move to `sell` from `buy`. So, we can find a profit of `buy` and `sell` state at a day `i` by the below function.

>buy(i) = maxSell(i-1) - cost(i)  
>sell(i) = maxBuy(i-1) + cost(i) - fee

And, `maxBuy(0)` is (cost(i) * -1) because it should buy at least one stock in `buy` state, and `maxSell(0)` is 0 because it does not have a stock to sell. With the upper two functions and this initial state, we can find the maximum profit at the day `n` by `maxSell(n)`.

A time complexity is O(n) because we need to find the maximum profit from 1st day to n-th day.  
A space complexity is O(1) because we save the last maximum profit on `buy` and `sell` state.

- Time complexity: O(n)
- Space complexity: O(1)
