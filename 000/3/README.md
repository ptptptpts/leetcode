# Longest Substring Without Repeating Characters

## Problem

Given a string s, find the length of the longest substring without repeating characters.

## Input

String s

## Example

- Example 1:

>Input: s = "abcabcbb"  
Output: 3  
Explanation: The answer is "abc", with the length of 3.

- Example 2:

>Input: s = "bbbbb"  
Output: 1  
Explanation: The answer is "b", with the length of 1.

- Example 3:

>Input: s = "pwwkew"  
Output: 3  
Explanation: The answer is "wke", with the length of 3.  
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

## Constraints

- 0 <= s.length <= 5 * 10^4
- s consists of English letters, digits, symbols and spaces.

## Output

The length of the longest substring without repeating characters.

## Solution 1

First, this problem is similar with the other substring problem, we can find the longest substring by finding the longest substring that ends with an each character.  
Next, to find a substring without repeating characters, we can record a position of each character previously it used. And, if a current character is already recorded as it used previously, we can find this substring has a repeating character.  
When we found a repeating character, we know a previous position `p` of a repeating character `c` by finding it from a record. Then, the longest substring that conatins a current character `c` can be from `p + 1`. To update previous records by a current substring, we can traverse a record array and clear all the positions that lower than the previous position `p`.

A time complexity is O(n) because we need to traverse an entire string. On an each repeated character, we update a record array with a size of byte. But it does not include a time complexity because it has a constant cost regardless of a length of String.  
A space compelxity is O(1) because we have a record array with a size of byte.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

This solution is almost same with the solution 1, but it has a different logic to find a current length of a substring and update a record logic.  

To find a current lenght of a substring, this logic does not count a length of substring. It saves a start of a current subarray instead of that.  
Next, this logic update a record logic by traverse again from the previous start to a previous position `p` of a repeating character `c`.  

This logic seems to have a time complexity as O(n^2), but it is O(n) because it is same with using two cursors that points a start and end of a substring.
