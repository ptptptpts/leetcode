# Maximum Length of Subarray With Positive Product

## Problem

Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [1,-2,-3,4]  
Output: 4  
Explanation: The array nums already has a positive product of 24.

- Example 2:

>Input: nums = [0,1,-2,-3,-4]  
Output: 3  
Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.  
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.

- Example 3:

>Input: nums = [-1,-2,-3,0,1]  
Output: 2  
Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].

## Constraints

- 1 <= nums.length <= 10^5  
- -10^9 <= nums[i] <= 10^9

## Output

A length of the longest subarray which product is a positive.

## Solution 1

Similar with the maximum positive of a subarray, we can traverse an array by forward and backward and count a non-zero streek. When we meet a negative integer, we can mark it as a boolean like isNegative and find the longest subarray only when isNegative is true.

A time complexity is O(n) because we traverse the given array twice by forward and backward.  
A space complexity is O(1) because we save only a non-zero streek on a current position and isNegative.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

This problem is similar with a problem to find the maximum product of a subarray, but it is different because a long subarray always has a larger value than a short subarray. So, we don't need to traverse the given array by backward and count a positive streek and negative streek on each position.  
When we meet a negative number, we change a positive and negative streek and increase a negative streek and positive streek if it is larger than 0. And, when we meet a positive number, we increase a positive and negative streek. Last, when we meet 0, we reset a positive and negative streek as 0.

A time complexity is O(n) because we need to traverse the given array at least once.  
A space complexity is O(1) because we save only the positive and negative streek.

- Time complexity: O(n)
- Space complexity: O(1)
