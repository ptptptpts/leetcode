# Beautiful Array

## Problem

For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:

For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].

Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

## Input

Size of array

## Example

Example 1:

Input: n = 4  
Output: [2,1,4,3]

Example 2:

Input: n = 5  
Output: [3,1,2,5,4]

## Constraints

1 <= n <= 1000

## Output

Integer array that satisfy two conditions.

1) Beautiful Array
2) For every i < j, no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].

## Solution 1

Let's assume we have the array with size n that satisfy the two conditions. When we add n+1 to here, we need to care about a position of n+1 because the other integers already satisfy the conditions.

About the first condition Beautiful Array, we don't need to care about it because we add the next integer on the beautiful array.

About the second condition, nums[k] * 2 is always even. So, it should be happened when nums[i] and nums[j] are both even or odd. Therefore, if we have an array with only odd integers and with only even integers, an array that merge them satisfy the second condition.

For example, let's assume we have the array with size i and it contains only odd integers, and also we have the array with size j and it contains only even integers. If we merge them it will look like this.

>[ Odd integers ] [ Even integers ]

If we select one integers from odd section, it satisfy the second condition. Because all even integers are on the right side of this integer, so they could not make an even if they add with the left side of this integer. Next, odd integers in the right side of this integer satisfy the second condition because the array with odd integer already satisfy the second condition. It can be applied on all the even integers, so this array satisfy the second condition.

To make this array, let's assume we have a list of arrays that contains all the arrays satisfy the second condition. If we want to make the array with size n, we need to merge two arrays with size n/2. However, the array with size 2/n contains integers from 1 to 2/n, we need to convert them as odd and even. We can convert an integer n to matched odd by "f(n) = n x 2 - 1", and also we can convert it to even by "f(n) = n x 2".

The Time complexity is O(nlogn), because we divide the array as half on each round until it reduce to 1 and we traverse an array on each round.

The Space complexity is O(nlogn), because we make an array on each round.

- Time complexity: O(n^2)
- Space complexity: O(n)
