# Ransom Note

## Problem

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

## Input

Two strings ransom note and magazine

## Example

- Example 1:

>Input: ransomNote = "a", magazine = "b"  
Output: false

- Example 2:

>Input: ransomNote = "aa", magazine = "ab"  
Output: false

- Example 3:

>Input: ransomNote = "aa", magazine = "aab"  
Output: true

## Constraints

- 1 <= ransomNote.length, magazine.length <= 10^5
- ransomNote and magazine consist of lowercase English letters.

## Output

True if we can construct a ransom note from the letters in a magazine.

## Solution 1

We don't need to care about order of a ransom note and magazine, and the
only thing we need to check is a number of each character. So, we can
count a number of character in a ransomNote and magazine, and compare a 
number of each character between both arrays. If a number of characters
in a ransomNote is lower or equal than a magazine, we can make a string.
In other case, we can't make a string.

A time complexity is O(n) because we need to count all the characters in
both strings.  
A space complexity is O(1) because we use arrays with a size of English
letters.

- Time complexity: O(n)
- Space complexity: O(1)
