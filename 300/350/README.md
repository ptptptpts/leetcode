# Intersection of Two Arrays II

## Problem

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

## Input

Two integer arrays

## Example

- Example 1:

>Input: nums1 = [1,2,2,1], nums2 = [2,2]  
Output: [2,2]

- Example 2:

>Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]  
Output: [4,9]  
Explanation: [9,4] is also accepted.

## Constraints

- 1 <= nums1.length, nums2.length <= 1000
- 0 <= nums1[i], nums2[i] <= 1000

## Output

Integer array that contains all intersections between two arrays

## Solution 1

This problem does not care of order of intersection, so only a number of each integer is important. For example, we can count a number of each integer from nums1 and nums2, and collect a smaller one from both arrays to find all intersections.  
But this solution has a restriction on a range of nums1[i] and nums2[i] because it need to build an array based on the range. If the range is too large to build an array, we can't use this solution.

Assume a length of nums1 and nums2 is `n` and a range of nums1[i] and nums2[i] is `m`.  
A time complexity is O(n + m) because we need to traverse a given nums1 and nums2 to count a number of each integer. and traverse the array that contains a number of each integer again.  
A space complexity is O(m) because we need to save a number of each integer in one of a given array and save an intersections in the other array.

- Time complexity: O(n + m)
- Space complexity: O(n + m)

## Solution 2

If both arrays are sorted, we can compare them with two cursors. If a integer that two cursors point is same, it can be intersection and move two cursors to the next one. If one of them is large, we can move a cursor that point a smaller one to the next because the array is sorted.  
This solution does not depends on a range of nums[i], but it has a weekness a size of nums1 and nums2.

Assume a length of nums1 and nums2 is `n` and a range of nums1[i] and nums2[i] is `m`.  
A time complexity is O(nlogn) if we use a sorting algorithm in O(nlogn) time complexity, because we need to sort both nums1 and nums2 arrays.  
A space complexity is O(n) because we need to save intersections in the other array.

- Time complexity: O(nlogn)
- Space complexity: O(n)
