# Coin Change 2

## Problem

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

## Input

Integer amount and Integer array that contains a price of coins.

## Example

- Example 1:

>Input: amount = 5, coins = [1,2,5]  
Output: 4  
Explanation: there are four ways to make up the amount:  
5=5  
5=2+2+1  
5=2+1+1+1  
5=1+1+1+1+1

- Example 2:

>Input: amount = 3, coins = [2]  
Output: 0  
Explanation: the amount of 3 cannot be made up just with coins of 2.

- Example 3:

>Input: amount = 10, coins = [10]  
Output: 1

## Constraints

- 1 <= coins.length <= 300
- 1 <= coins[i] <= 5000
- All the values of coins are unique.
- 0 <= amount <= 5000

## Output

The number of combinations that make up the given amount.

## Solution 1

First, we can think this problem is similar with the problem like a climbing stairs. This problem is different because a climbing stairs has an order on each stairs, but this problem does not have an order between each coins. If we make a `5` with `2 + 2 + 1` and `1 + 2 + 2`, they are same in this problem. So, we can't solve this problem by finding a sum of the previous available combinations.  
To not care an order of coins, we need to not care the other coins when finding combinations with a coin. So, similar but difference with a climbing stairs problem, we need to find combinations until the amount on each coin.  
For example, if we have the amount 5, and coins as [1, 2, 5]. We can find the combinations on `1` first like this.  

Combinations|c(0)|c(1)|c(2)|c(3)|c(4)|c(5)
----|----|----|----|----|----|----
0|1|0|0|0|0|0
1|1|1 (c(1)+c(0))|1 (c(2)+c(1))|1 (c(3)+c(2))|1 (c(4)+c(3))|1 (c(5)+c(4))

Then, we can find the combinations on `2` with this array. In this case, we don't have any duplicates because the previous history only have the `1` coin.

Combinations|c(0)|c(1)|c(2)|c(3)|c(4)|c(5)
----|----|----|----|----|----|----
0|1|0|0|0|0|0
1|1|1|1|1|1|1
2|1|1|2 (c(2)+c(0))|2 (c(3))+c(1))|3 (c(4)+c(2)|3 (c(5)+c(3))

And then, after finding the combinations on `5`, we can find the number of combinations with the given amount and coins.

Combinations|c(0)|c(1)|c(2)|c(3)|c(4)|c(5)
----|----|----|----|----|----|----
0|1|0|0|0|0|0
1|1|1|1|1|1|1
2|1|1|2|2|3|3
5|1|1|2|2|3|4 (c(5)+c(0))

`n` is the given amount, and `m` is a number of coins.
A time complexity is O(n * m), because we find all the combinations with the given coins from 1 to the amount.  
A space complexity is O(n), because we save a number of the combinations at each amount.

- Time complexity: O(n * m)
- Space complexity: O(n)
