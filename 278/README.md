# First Bad Version

## Problem

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

## Input

The number of the last version

## Example

- Example 1:

>Input: n = 5, bad = 4  
Output: 4  
Explanation:  
call isBadVersion(3) -> false  
call isBadVersion(5) -> true  
call isBadVersion(4) -> true  
Then 4 is the first bad version.

- Example 2:

>Input: n = 1, bad = 1  
Output: 1

## Constraints

- 1 <= bad <= n <= 2^31 - 1

## Output

The number of the first bad version

## Solution 1

Basically, we can assume we have a list that contains only false and
true, and we need to find the first position that contain a true. To
find this position as a minimal cost, we can traverse the array as a
binary tree. If a position `i` is false, we need to find a right half
of `i` to find a position with a true. And if a position `i` is true, 
we need to find a left half of `i` to find a position with false. Each
loop, we need to select `i` as a middle of current window to reduce a
size of window as half. If a size of window is 2 and they contain false
and true, the true is the first bad version.  

A time complexity is O(log n) because we search the position as a binary
search.  
A space complexity is O(1) because we save only the left and right side
of a current window.

- Time complexity: O(log n)
- Space complexity: O(1)
