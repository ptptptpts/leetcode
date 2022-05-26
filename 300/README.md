# Longest Increasing Subsequence

## Problem

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

## Input

Integer array

## Example

- Example 1:

>Input: nums = [10,9,2,5,3,7,101,18]  
Output: 4  
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

- Example 2:

>Input: nums = [0,1,0,3,2,3]  
Output: 4

- Example 3:

>Input: nums = [7,7,7,7,7,7,7]  
Output: 1

## Constraints

- 1 <= nums.length <= 2500
- -10^4 <= nums[i] <= 10^4

## Output

A length of the longest increasing subsequence can be made by the given array

## Solution 1

If we traverse the array by forward, we can't know the longest increasing subsequence at the position `i` because we don't know the next numbers. But, if we traverse the array by backward, we can find the longest increasing subsequence at the positoin `i` because we already check all the previous numbers.  
When we traverse the array by backward and we are in the position `i`, the longest increasing subsequence at the `i` can be made by the previous longest increasing subsequence that starts with a larger one than `i`. So, if we know the longest subsequence at the previous positions, we can find the longest subsequence at the current position. And, at the last number of the array, a length of the longest subsequence is 1. Therefore, we can find the longest subsequence at any position `i` by searching backward.

A time complexity is O(n^2) because we traverse the previous numbers again on each number.  
A space complexity is O(n) because we save the longest increasing subsequence on each position.

- Time complexity: O(n^2)
- Space complexity: O(n)

## Solution 2

Let's assume we have the longest increasing subsequence `s(i)` at the current position `i`. If `i+1` can be in the subsequence `s(i)`, we can record it in `s(i)` by replace the first integer larger than `i+1`. Even if `i+1` is not in the longest increasing subsequence for the given array, we don't need to care that because replacing in the middle of subsequence could not have any effect on a length of it.  
Then, with this logic, on each element `e`, we will find a position of `e` from the subsequence. We can find it by binary search, so its cost can be O(logn) and we'll repeat this for the all elements.

A time complexity is O(nlogn) because we find a position of `i` by binary search.  
A space complexity is O(n) because we will save all the elements in the worst case.

- Time complexity: O(nlogn)
- Space complexity: O(n)
