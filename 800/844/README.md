# Backspace String Compare

## Problem

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

## Input

String s and t

## Example

- Example 1:

>Input: s = "ab#c", t = "ad#c"  
Output: true  
Explanation: Both s and t become "ac".

- Example 2:

>Input: s = "ab##", t = "c#d#"  
Output: true  
Explanation: Both s and t become "".  

- Example 3:

>Input: s = "a#c", t = "b"  
Output: false  
Explanation: s becomes "c" while t becomes "b".

## Constraints

- 1 <= s.length, t.length <= 200
- s and t only contain lowercase letters and '#' characters.

## Output

True if both String is same when they are typed into empty text editors.

## Solution 1

The string s and t contains only lowercase letters and '#' characters. So, we can use a
'#' character to describe an invalid character to ignore when we compare both string s
and t. First, we can convert both string s and t to remove all the character that will be
removed by '#' character. After then, we can compare both strings with ignoring '#'
character. Then, we can compare both strings without using any additional memory.  

A time complexity is O(n) because we need to traverse the string s and t twice.  
A space complexity is O(1) because we don't use any additional space.

- Time complexity: O(n)
- Space complexity: O(1)

## Solution 2

We can traverse the string s and t from end to start. If we find a `#` character, we can
move a cursor to left side and increase a number of backspaces. And if we find a
lowercase character but a number of backspaces is higher than 0, we can move a cursor to
left and decrease a number of backspaces. If both cursors points a lowercase character
and a number of backspaces is 0, we can compare both characters. And, if one of the
cursor is already finished when we find a character from the other string, we can find 
it is different with the other string.

A time complexity is O(n) because we need to traverse the string s and t from end to
start.    
A space complexity is O(1) because we use only two cursors and save a number of
backspaces. 

- Time complexity: O(n)
- Space complexity: O(1)
