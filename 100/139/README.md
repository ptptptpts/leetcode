# Word Break

## Problem

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

## Input

String s and a list of Strings for wordDict.

## Example

- Example 1:

>Input: s = "leetcode", wordDict = ["leet","code"]  
Output: true  
Explanation: Return true because "leetcode" can be segmented as "leet code".

- Example 2:

>Input: s = "applepenapple", wordDict = ["apple","pen"]  
Output: true  
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".  
Note that you are allowed to reuse a dictionary word.  

- Example 3:

>Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]  
Output: false

## Constraints

- 1 <= s.length <= 300
- 1 <= wordDict.length <= 1000
- 1 <= wordDict[i].length <= 20
- s and wordDict[i] consist of only lowercase English letters.
- All the strings of wordDict are unique.

## Output

True if the String s can be made by words in the given wordDict.

## Solution 1

First, anyway we need to compare Strings in the wordDict with a substring of the String s. So, convert a list of wordDict to a HashSet to reduce a time to compare them.  

Next, at the `n`th char of the String s, we can find any substrings from the `n`th character is included in the wordDict or not by searching it from the HashSet. If a word with a length `m` is available at the `n`th position, a String to the `n + m`th position is also available one with the wordDict.

For saving an availability on each position, we need to mark it on a boolean array with a length of the String s. And, during searching from 0th position of the given String s, we can skip the `n`th position if we can't reach to the `n`th position.

A time complexity is O(s.length * wordDict[i].length + wordDict.length), because we need compare entire String s with a word in the wordDict(O(s.length \* wordDict[i].length)) and build a HashSet with the wordDict(O(wordDict.length)).
A space complexity is O(s.length + wordDict.length), because we save a validity at the each position as a boolean array(O(s.length)) and save the wordDict as a HashSet(O(wordDict.length)).

- Time complexity: O(s.length * wordDict[i].length + wordDict.length)
- Space complexity: O(s.length + wordDict.length)
