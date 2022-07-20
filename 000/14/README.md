# Longest Common Prefix

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

## Input

Array of Strings

## Example

- Example 1:

>Input: strs = ["flower","flow","flight"]  
Output: "fl"

- Example 2:

>Input: strs = ["dog","racecar","car"]  
Output: ""  
Explanation: There is no common prefix among the input strings.

## Constraints

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lowercase English letters.

## Output

The longest common prefix amongst an array of strings

## Solution 1

To compare all the strings, basically we need to check all the string in the given str.
Next, we can assume the first string in the str can be the longest common prefix, and
adding each string to the str. So, when we add each string, we can find a prefix between
two strings and can update a current prefix between two strings. After then, we can
repeat this until we check all the strings in the str or a current prefix is empty
string.

A time complexity is O(strs.length * strs[i].length), because we need to compare entire
all the strings in the worst case.  
A space complexity is O(strs[i].length), because we save a current prefix to compare
with the next string.

- Time complexity: O(n * m)
- Space complexity: O(m)
