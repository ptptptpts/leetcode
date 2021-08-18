# Decode Ways

## Problem

A message containing letters from A-Z can be encoded into numbers using the following mapping:

```bash
'A' -> "1"  
'B' -> "2"
... 
'Z' -> "26"
```

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

* "AAJF" with the grouping (1 1 10 6)
* "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

## Input

Encoded string that contains only digits.

## Example

Example 1:

```bash
Input: s = "12"  
Output: 2  
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).  
```

Example 2:

```bash
Input: s = "226"  
Output: 3  
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).  
```

Example 3:

```bash
Input: s = "0"  
Output: 0  
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.  
Hence, there are no valid ways to decode this since all digits need to be mapped.
```

Example 4:

```bash
Input: s = "06"  
Output: 0  
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 ```

## Constraints

* 1 <= s.length <= 100
* s contains only digits and may contain leading zero(s).

## Output

A number of ways can decode the input string.

## Solution 1

At the n-th character, it can be decoded by itself or with the previous character.  

So, if we can decode the n-th character by itself and with the n-1 th character, a number of ways can decode at the n-th character is sum of a number of decoding ways at the n-1 th character and the n-2 th character.  

At the same way, if we can't decode the n-th character with the previous character, a number of ways can decode at the n-th character is same with a number of decoding ways at the n-1 th character.

In additional, if we can't decode the n-th character by itself and with the previous character, we can't decode this string.

The time complexity is O(n) because we traverse the string only once.

The Space complexity is O(1) because we save a number of decoding ways with the last two characters.

- Time complexity: O(n)
- Space complexity: O(1)
