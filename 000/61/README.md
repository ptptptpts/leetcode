# Rotate List

## Problem

Given the head of a linked list, rotate the list to the right by k places.

## Input

Head of the linked list and integer k to rotate the list

## Example

- Example 1:

>Input: head = [1,2,3,4,5], k = 2  
Output: [4,5,1,2,3]

- Example 2:

>Input: head = [0,1,2], k = 4  
Output: [2,0,1]

## Constraints

- The number of nodes in the list is in the range [0, 500].
- -100 <= Node.val <= 100
- 0 <= k <= 2 * 10^9

## Output

Head of the rotated linked list

## Solution 1

We can divide the problem by two steps. The first is finding a length of the list and
find a number we need to rotate the list. The second is to rotate the list in the number
we find.

In the first step, we can find a length of the list by traverse the list. Next, we can
find a number that we need to rotate the list by `k % length`.

In the second step, if the array is rotated `k` times to right, it means the node before
`k` from the end of the list will be a head of the list. And, the previous end of the
list will be connected with the previous head of the list. Because we already know a
length of the list and a number that we need to rotate the list, we can find a position
of a new head of the rotated list. And, we can move the previous node of the new head as
a new tail, and connect the previous tail to the previous head.

A time complexity is O(n) because we need to traverse the given list twice.  
A space complexity is O(1) because we don't save any previous history and just modify the
given list.

- Time complexity: O(n)
- Space complexity: O(1)
