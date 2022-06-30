# Valid Palindrome

## Problem

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

## Input

String s

## Example

- Example 1:

>Input: s = "A man, a plan, a canal: Panama"  
Output: true  
Explanation: "amanaplanacanalpanama" is a palindrome.

- Example 2:

>Input: s = "race a car"  
Output: false  
Explanation: "raceacar" is not a palindrome.

- Example 3:

>Input: s = " "  
Output: true  
Explanation: s is an empty string "" after removing non-alphanumeric characters.  
Since an empty string reads the same forward and backward, it is a palindrome.

## Constraints

- 1 <= s.length <= 2 * 10^5
- s consists only of printable ASCII characters.

## Output

Return true if the given String s is a palindrome

## Solution 1

Palindrome compares after converting all uppercase letters to lowercase letters and removing all non-alphanumeric characters. We can do it via replace all characters in a regex `[^a-zA-Z0-9]` to `""`. After then, we can convert all uppercases to lowercases. A result of this two process contains only lowercase and digit letters, we can find it is a palindrome or not by comparing with start and end.

A time complexity is O(n) because we need to convert the given String s and check it is palindrome or not.  
A space complexity is O(n) because we need a buffer to save the given String when converting it.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Regex is simple, but using a heavy cost. So, this solution does not convert the given String s and find a palindrome on there. It uses two cursor at start and end, and they will move a forward and backward. If one of them meet a non-alphabetic and non-digit character, only the cursor moves to the next character. If the both cursors points a alphabetic or digit character, replace it to lower character and compare them to find a palindrome. If they aren't same, this string is not a palindrome, and if a start cursor is higher then a end cursor, this string is a palindrome.

A time complexity is O(n) because we need to traverse the given Strings from backward and forward.  
A space complexity is O(1) because we don't need an extra memory to save something.

- Time complexity: O(n)
- Space complexity: O(1)
