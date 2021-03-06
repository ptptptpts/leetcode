# Maximum Subarray

## Problem

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

## Input

Integer array.

## Constraints

- 1 <= nums.length <= 3 * 104
- -105 <= nums[i] <= 105

## Output

The largest sum that can be created by the contiguous subarray.

## Solution 1

We can find the largest sum on n th integer by comparing the subarray with n the integer and the previous largest sum.  
In additional, if the n th integer is larger than a sum of the subarray with n th integer, we can assume the next subarray will contain only n th array.

Let's assume the given integer is [-2,1,-3,4,-1,2,1,-5,4].

With the first integer [-2], the largest sum is -1 and current subarray sum is 0.
With the second integer [-2,1], the current subarray sum is 0+[1]=1 and the largest sum is updated to 1.  
With the third integer [-2,1,-3], the current subarray sum is 1+[-3]=0 and the largest sum is still 1.  
With the fourth integer [-2,1,-3,4], the current subarray sum is 0+[4]=4 and the largest sum is updated to 4.  
With the fifth integer [-2,1,-3,4,-1], the current subarray sum is 4+[-1]=3 and the largest sum is still 4.  
With the sixth integer [-2,1,-3,4,-1,2], the current subarray sum is 3+[2]=5 and the largest sum is updated to 5.  
With the seventh integer [-2,1,-3,4,-1,2,1], the current subarray sum is 5+[1]=6 and the largest sum is updated to 6.  
With the eighth integer [-2,1,-3,4,-1,2,1,-5], the current subarray sum is 6+[-5]=1 and the largest sum is still 6.  
With the ninth integer [-2,1,-3,4,-1,2,1,-5,4], the current subarray sum is 1+[4]=5 and the largest sum is still 6.  

A time complexity is O(n) because we need to track the entire given integer array.  
A space complexity is O(1) because we need to save only the current subarray sum and the largest sum.

- Time complexity: O(n)
- Space complexity: O(1)

## For Best Performance

1) We can use the Math.max(a, b) to assign the larger one on variable, instead of comparing a and b by if statement. The cost of Math.max(a, b) is almost similar or less than if statement.
