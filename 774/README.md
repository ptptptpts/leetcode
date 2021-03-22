# First Bad Version

## Problem

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

## Input

Integer n, number of versions.

## Constraints

- 1 <= bad <= n <= 2^31 - 1

## Output

Integer bad, a number of bad version.

## Solution 1

First, n versions have at least one bad version. So, n th version is always a bad version.

Next, the first bad version - 1 is always non-bad version. Therefore we need to find a version with the below position.

| Version | isBadVersion |
|---|---|
| 1 | false |
| 2 | false |
| ... | false |
| bad-1 | false |
| bad | true |
| ... | true |
| n-1 | true |
| n | true |

To find this 'bad' position, we can use two cursors for finding the first 'true' version, and the last 'false' version. Because n th version is always 'bad' version, we can start the first 'true' version as n th version. And a version is start from 1 th version, so we can start the last 'false' version as 0 th version.

To search the first 'true' position, we can search the array by binary search. On each round, we can query a middle of the last 'false' version and the first 'true' version. If it is 'true' version, we can move the first 'true' version as the middle one. If it is 'false' version, we can move the last 'false' version as the middle one. On each round, we compare two cursors and finish the loop if the last 'false' version is the next of the first 'true' version.

About time complexity, it is O(logn) because we search a size of n as binary search.
About space complexity, it is O(1) because we use only two cursors.

- Time complexity: O(logn)
- Space complexity: O(1)

## Caution

Because n is start from 0 and the end of unsigned integer max number, a sum of two cursors can be exceed an integer range. So, we should convert them as long when finding a middle of two cursors.
