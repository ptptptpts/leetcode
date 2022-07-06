# Product of Array Except Self

## Problem

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [1,2,3,4]  
Output: [24,12,8,6]

- Example 2:

>Input: nums = [-1,1,0,-3,3]  
Output: [0,0,9,0,0]

## Constraints

- 2 <= nums.length <= 10^5
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

## Output

Integer array that contains the product of all elements of nums except nums[i]

## Solution 1

The product of all the elements of nums except nums[i] is same with the
product of all the elements left of nums[i] and right of nums[i]. So,
we can make an array that has the product of all the elements from left
to right, and can make the similar array that has the product of all the
elements from right to left. To find the result at the nums[i], we can
find it by multiply nums[i-1] from the first array and nums[i+1] from
the second array.

A time complexity is O(n) because we just traverse the given array 3 
times.  
A space complexity is O(n) because we need to calculate and save the
product from left to right and right to left.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

We can improve the Solution 1 to not use extra array except an array to
return a result. Let's focus on we already have one array to save a
result. First, we can save all the product from left to right. And, we
can calculate a result of each position if we multiply the product from
right to left. About the product from right to left, we don't need to
save the product of each position because we multiply them to each
position. So we save only the product of the current position. For
example, the result of `i`th position `f(i)` can be made by product of
the product from left to right `l(i-1)` and from right to left `r(i+1)`.
But, the `l(i-1)` is already saved in the result array, and the `r(i+1)`
is saved on the variable and multiply on each position.  

A time complexity is O(n) because we need to traverse the given array two
times to find the product from left to right and right to left.  
A space complexity is O(1) because we use only the extra memory for
saving the returning result.

- Time complexity: O(n)
- Space complexity: O(1)
