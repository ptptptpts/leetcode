# Counting Bits

## Problem

Given an integer n, return an array `ans` of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

## Input

Integer n

## Example

- Example 1:

>Input: n = 2  
Output: [0,1,1]  
Explanation:  
0 --> 0  
1 --> 1  
2 --> 10

- Example 2:

>Input: n = 5  
Output: [0,1,1,2,1,2]  
Explanation:  
0 --> 0  
1 --> 1  
2 --> 10  
3 --> 11  
4 --> 100  
5 --> 101

## Constraints

- 0 <= n <= 10^5

## Output

Integer array with a size of n+1 that contains a number of 1 in the binary representation
of i

## Solution 1

A number of 1 if the binary has no bit is [0()].
A number of 1 if the binary has only one bit is [1(1)].  
A number of 1 if the binary has two bits is [1(10), 2(11)].  
A number of 1 if the binary has three bits is [1(100), 2(101), 2(110), 3(111)].  
A number of 1 if the binary has four bits is [1(1000), 2(1001), 2(1010), 3(1011), 2(1100), 3(1101), 3(1110), 4(1111)].

So, the number of elements on each length of the binary can be defined by 2^(n-1) if a
length of the binary is n.  

Next, we can make a number of 1 on each length of the binary by adding the previous
number of 1 of the previous length. For example, if we want to build a list of number
of 1 when the binary has five bits, we can assume it has the first bit `1` and append the
other bits from the previous history like this.  

>1(10000), 1+1(1 + 0001), 1+1(1 + 0010), 1+2(1 + 0011), 1+2(1 + 0100), ... , 1+4(1+1111)

So, we can find a number of `1` of each integer directly if we have all the previous
histories. And, this problem requires to return all the histories of a number of `1`,
we can find a number of `1` of each integer in O(1) cost.  

A time complexity is O(n) because we can find a number of `1` in each integer by O(1)
cost, but we need to find all the number of `1` until the given n.  
A space complexity is O(1) without an integer array we need to return as a result. 

- Time complexity: O(n)
- Space complexity: O(1)
