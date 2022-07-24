# Find Minimum in Rotated Sorted Array

## Problem

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

- [4,5,6,7,0,1,2] if it was rotated 4 times.
- [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

## Input

Integer array that sorted in ascending order but rotated between 1 to n times.

## Example

- Example 1:

>Input: nums = [3,4,5,1,2]  
Output: 1  
Explanation: The original array was [1,2,3,4,5] rotated 3 times.  

- Example 2:

>Input: nums = [4,5,6,7,0,1,2]      
Output: 0  
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.  

- Example 3:

>Input: nums = [11,13,15,17]  
Output: 11  
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

## Constraints

- n == nums.length
- 1 <= n <= 5000
- -5000 <= nums[i] <= 5000
- All the integers of nums are unique.
- nums is sorted and rotated between 1 and n times.

## Output

The minimum value in the given array.

## Solution 1

Basically, we can search any specific number from the given array in O(log n) cost by
a binary search. If the number we need to find in the minimal one, we can find it by
comparing it with its left element. If some element is lower than its left element, it
is the minimal element because the array is sorted in ascending order. So, we can
convert the problem to find a minimal or maximal peek.

Let's assume the first element of a current window is f(w), a middle element is m(w),
and the last element is l(w). If a current window satisfy a `f(w) < m(w) < l(w)`, this
window does contain a peek because no element before l(w) can't be higher than l(w). And,
if a current windows contains the minimal peek at a middle of a window, it will satisfy
a `f(w) > m(w) < l(w), l(w) < f(w)` and its size is 3. In additional, the given array
will have only one or no peek, we can find the minimal peek by a binary search.  

A time complexity is O(log n) because we find it by a binary search.  
A space complexity is O(1) because we save only a position of a current window.

- Time complexity: O(log n)
- Space complexity: O(1)
