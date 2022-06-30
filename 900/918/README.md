# Maximum Sum Circular Subarray

## Problem

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

## Input

Integer array that contains a circular array

## Example

- Example 1:

>Input: nums = [1,-2,3,-2]  
Output: 3  
Explanation: Subarray [3] has maximum sum 3.  

- Example 2:

>Input: nums = [5,-3,5]  
Output: 10  
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

- Example 3:

>Input: nums = [-3,-2,-3]  
Output: -2  
Explanation: Subarray [-2] has maximum sum -2.

## Constraints

- n == nums.length
- 1 <= n <= 3 * 10^4
- -3 \* 10^4 <= nums[i] <= 3 \* 10^4

## Output

The maximum sum of the subarray.

## Solution 1

If the maximum sum of subarray exists in a linear range, we can find it by finding the maximum local sum on each num.  

But, if the maximum sum of subarray exists in a circular array, it should contain the first and last num and not contains a some subarray in a linear range like this.  

Array|||||||||||
----|----|----|----|----|----|----|----|----|----|----|
Num|5|-1|3|2|-3|-2|-1|1|2|5
Contains|O|O|O|O|X|X|X|O|O|O

So, we can convert a problem to find the minimum sum of a subarray that does not contain the first or last num. And the sum of this array can be found by subtract the minimum sum from sum of all nums.  

The time complexity is O(n) because we find the minimum and maximum sum, and sum of all nums. They can be found in O(n).  
The space complexity is O(1) because we save only the minimum and maximum sum, and sum of all nums.

- Time complexity: O(n)
- Space complexity: O(1)
