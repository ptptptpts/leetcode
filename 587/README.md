# Merge Sorted Array

## Problem

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

## Input

- nums1: Sorted integer array
- m: Number of elements of nums1
- nums2: Sorted integer array
- n: Number of elements of nums2

## Constraints

- nums1.length == m + n
- nums2.length == n
- 0 <= m, n <= 200
- 1 <= m + n <= 200
- -109 <= nums1[i], nums2[i] <= 109

## Output

Put merged sorted array on nums1

## Solution 1

For using nums1 as buffer, we can move all the elements in nums1 to right as 'n'.  
After moving the elements, now we can find the n-th larger elements in both nums1 and nums2 array and moving it to n-th position of nums1.
Because all the elements of nums1 are already moved to right side as 'n', we won't meet any overwrite problem even if all the elements of nums2 are smaller than nums1.

Therefore, after moving the elements of nums1, we can use three cursors for merged array, nums1, and nums2.
If a current nums1 element is smaller than a element of nums2, we can copy it to a current position of merged array and move cursors of merged array and nums1.
On the other way, if a current nums1 element is larger than a element of nums2, we can copy it as same way with nums1 and move the cursors as same as before.

About Time complexity, we need to track all the elements of nums1 and nums2. So, time complexity is O(n+m).
About space complexity, we don't need any additional array to make merged array. So, space complexity is O(1)

- Time complexity: O(n + m)
- Space complexity: O(1)

## Caution!

When move the elements of nums1, we should start from the most right element of nums1.
Because if we start from the left elements, it can overwrite some other element not moved yet.

## Solution 2

Similar with Solution 1, but it starts from the largest number.
So, in this case, n elements of nums1 are already filled by '0' and we don't need to care about number overwrite problem that happens when we fill the nums1 from the smallest number.

## For Best Performance
