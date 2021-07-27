# Number of Matching Subsequences

## Problem

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

## Input

A String s and an array of strings words that contains a subsequnce of s.

## Example

Example 1:  
Input: s = "abcde", words = ["a","bb","acd","ace"]  
Output: 3  
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:  
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]  
Output: 2

## Constraints

- 1 <= s.length <= 5 * 10^4
- 1 <= words.length <= 5000
- 1 <= words[i].length <= 50
- s and words[i] consist of only lowercase English letters.

## Output

A number of subsequence strings in words.

## Solution 1

In the Constraints, a length of s is extreamly longer than a length of each word. So, it is better to find a subsequence word based on a word.  

To find a subsequence word, we need to find each character of the word from start of the string s. If we find the current character of the word, move to the next character of the word and find it again from the next character of the string s.

Because a length of each word is small, the words can contains a duplicat word. To reduce a cost to check the duplicate word again, we can save the word we already check in a HashMap with a result.

The Time Complexity is O(size of words * length of each word * length of string s) because we trace every characters in each word with the string s and it repeats whole of the words.

The Space Complexity is O(size of words) because we save a result of each word by HashMap to reduce a searching time on a duplicate words.

- Time complexity: O(size of words * length of each word)
- Space complexity: O(size of words)
