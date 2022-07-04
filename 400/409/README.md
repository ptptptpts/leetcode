# Longest Palindrome

## Problem

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

## Input

String s

## Example

- Example 1:

>Input: s = "abccccdd"  
Output: 7  
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.   

- Example 2:

>Input: s = "a"  
Output: 1  
Explanation: The longest palindrome that can be built is "a", whose length is 1.

## Constraints

- 1 <= s.length <= 2000
- s consists of lowercase and/or uppercase English letters only.

## Output

A length of the longest palindrome that can be built from the given string S.

## Solution 1

From the example, we can find we don't need to care about an order of
each character in the string S. So, we don't need to save a position of
each character and can count only a number of each character.  

If some string is a palindrome, a number of each character is even and
only the character in a middle of a palindrome is odd. So, anyway we
can use all the characters which number is even to build a palindrome
and can select a character which number is odd and the most frequently
shown in the string s. But, if there are no character which number is
odd, we can assume a length of a palindrome is even, so it will not have
a middle character.  

In conclusion, first we'll count a number of each character from the 
string S. And sum all the number of characters which number is even.
After then, we'll find the maximum number of character which number is
odd and add it to the result. The even characters will be located in the
left and right side of a palindrome, and the odd character will be
located in the middle of a palindrome.

A time complexity is O(n) because we need to check all the characters in
the given String s.  
A space complexity is O(1) because we save only the number of each
character regardless of a length of string s. 

- Time complexity: O()
- Space complexity: O(1)
