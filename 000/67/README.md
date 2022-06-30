# Add Binary

## Problem

Given two binary strings a and b, return their sum as a binary string.

## Input

Two binary Strings a and b 

## Example

- Example 1:

>Input: a = "11", b = "1"  
Output: "100"

- Example 2:

>Input: a = "1010", b = "1011"  
Output: "10101"

## Constraints

- 1 <= a.length, b.length <= 10^4
- a and b consist only of '0' or '1' characters.
- Each string does not contain leading zeros except for the zero itself.

## Output

The binary string that contains a sum of `a` and `b`

## Solution 1

We can use two cursors for each `a` and `b`, and traverse from their
end to start. And add two integers on each position, and found their
sum of each position. If they have any left, we can add them on the next
position. If one of cursor reach at the start position first, we can
assume it has '0'. And if both cursors reach at the start position, we
can check any left and adding '1' again if it exists. But, in this case,
we have a reversed binary string. So, we need to reverse it again after
finding a sum of those `a` and `b`. But, Java supports to append a
character at the starting of each StringBuilder, so we don't need to
reverse the result and just appending an integer on every position.
But, inserting a character at the starting of StringBuilder will make
a shift of buffer, so using reverse() at the end of process is cheaper
than that.

A time complexity is O(n) because we need to traverse a longer binary
string.  
A space complexity is O(n) because a length of sum of two integers is
depends on a length of two integers.

- Time complexity: O(n)
- Space complexity: O(n)
