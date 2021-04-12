# Longest Common Prefix

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

## Input

String array

## Example

Input: strs = ["flower","flow","flight"]  
Output: "fl"

Input: strs = ["dog","racecar","car"]  
Output: ""  
Explanation: There is no common prefix among the input strings.

## Constraints

- 0 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lower-case English letters.

## Output

The longest String prefix

## Solution 1

This problem is not about sub-string and it is about prefix.
So, we can start to find the shortest String to reduce a condition.
If we find the shortest String, we can find the longest prefix from the 0-th character of the shortest String.
Because any String can have a different character, we need to find a n-th character on the all Strings in the input array.

The Time complexity is O(size of array * length of the shortest String), because we need to compare a n-th character from all the Strings in array.
The Space complexity is O(length of the shortest String), because we need to make a new String that have the longest prefix.

- Time complexity: O()
- Space complexity: O(1)

## Deep dive in Java

In Java, StringBuilder() is faster than String object to update a new String. For example, String + String is slower than StringBuilder.append() because String + String will be converted to String -> StringBuilder -> StringBuilder.append() -> String.
