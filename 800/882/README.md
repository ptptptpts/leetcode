# Valid Anagram

## Problem

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

## Input

Two String s and t

## Example

Input: s = "anagram", t = "nagaram"  
Output: true

Input: s = "rat", t = "car"  
Output: false

## Constraints

- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of lowercase English letters.

## Output

True if t is anagram of s

## Solution 1

Simply we can verify t is anagram of s by counting each alphabet in s and t and comparing two arrays.

To use a one array to count each alphabet, we can increase each count on String s and decrease each count on String t. If all counts are '0', we can verify t is an anagram of s.

The Time complexity is O(length of String s) because we need to check all the characters in both String s and t.
The Space complexity is O(1) because we always use int[26] array for counting all alphabets.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

We can compare both String by using Java APIs.

First, we can change String s and t to char[] by String.toArray() method.  
Next, we can sort it by Arrays.sort(char[]) method.  
Last, comparing them by Arrays.compare(char[], char[]) method, and they are anagram if a return value is '0'.

The Time complexity is O(nlogn)(n is a length of String s) because we need to sort a character array.
The Space complexity is O(n)(n is a length of String s) because we need to create a new array that store all the characters in String s.

Big O notation is larger than Solution 1, but real speed is very fast because it uses Java public API.
Moreover, it has a strong point than Solution 1 because it can use it for finding anagram of unicode or larger datas by changing an array to short or integer.

- Time complexity: O(nlogn)
- Space complexity: O(n)
