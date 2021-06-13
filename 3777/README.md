# Palindrome Pairs

## Problem

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

## Input

Array of Strings

## Example

Input: words = ["abcd","dcba","lls","s","sssll"]  
Output: [[0,1],[1,0],[3,2],[2,4]]  
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Input: words = ["bat","tab","cat"]  
Output: [[0,1],[1,0]]  
Explanation: The palindromes are ["battab","tabbat"]

Input: words = ["a",""]  
Output: [[0,1],[1,0]]

## Constraints

- 1 <= words.length <= 5000
- 0 <= words[i].length <= 300
- words[i] consists of lower-case English letters.

## Output

List of List Integer that describes a pair of integers make palindrome.

## Solution 1

Compare all Strings each other and add it to Array if the current pair is palindrome.

The time complexity is O(n^2*m) (n is a length of words and m is a length of word), because it compares all pairs in the input array and find it is palindrome or not on all pairs.

The space complexity is O(1) because it does not use additional memory except making output integer array.

- Time complexity: O(n^2*m)
- Space complexity: O(1)

This solution is simple, but takes too much time cost. So, it failed by time exceed.

## Solution 2

Save all Strings to HashMap with its position and find an available palindrome String from the HashMap.  

On each String, it can make a palindrome by two ways, append the other String at the end point or append at the start point.  
So, make a substring from the start and end point, and find a reversed string from the HashMap.  
If the reversed String exists in the HashMap, add it to the output List if it is palindrome.

The time complexity is O(n*m) (n is a length of words and m is a length of word), because it check all the Strings and its substrings. In additional, it does not use additional cost to find a reversed String because it uses a HashMap.

The space complexity is O(n) because it saves all the Strings to HashMap.

- Time complexity: O(n*m)
- Space complexity: O(n)
