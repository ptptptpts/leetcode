# Longest Palindromic Subsequence

## Problem

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

## Input

String s

## Example

- Example 1:

>Input: s = "bbbab"  
Output: 4  
Explanation: One possible longest palindromic subsequence is "bbbb".

- Example 2:

>Input: s = "cbbd"  
Output: 2  
Explanation: One possible longest palindromic subsequence is "bb".

## Constraints

- 1 <= s.length <= 1000
- s consists only of lowercase English letters.

## Output

The length of the longest palindromic subsequence can be made by the given string s.

## Solution 1

Let's assume `f(i, j)` is a length of the longest palindromic subsequence starts from `i` and end at `j`. Then, if `s[i - 1]` is same with `s[j + 1]` is same, `f(i-1, j+1)` is `f(i, j) + 2`. And if `s[i - 1]` is same with `s[j + 1]` is different, `f(i-1, j+1)` is a larger one between `f(i-1, j)` and `f(i, j-1)`.  
And, we know `f(i, i)` is 1 because `s[i]` is same with `s[i]`, and `f(j, i)` is 0 if i < j because a subsequence keep its order.  
Then, we can initialize the array as 0 and fill all the `f(i, i)` position as `1`. And we can search the array from n to 0 and i to n.

A time complexity is O(n ^ 2) because we need to find all the longest palindrom subsequence in two dimension array.  
A space complexity is O(n ^ 2) because we need to find all the longest palindrom subsequence in each combination `f(i, j)`

- Time complexity: O(n^2)
- Space complexity: O(n^2)
