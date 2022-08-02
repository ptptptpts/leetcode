# Reorder List

## Problem

You are given the head of a singly linked-list. The list can be represented as:

```
L0 → L1 → … → Ln - 1 → Ln
```

Reorder the list to be on the following form:

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
```

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Input

A root of the linked list

## Example

- Example 1:

>Input: head = [1,2,3,4]  
Output: [1,4,2,3]

- Example 2:

>Input: head = [1,2,3,4,5]  
Output: [1,5,2,4,3]

## Constraints

- The number of nodes in the list is in the range [1, 5 * 10^4].
- 1 <= Node.val <= 1000

## Output

A root of the reordered linked list

## Solution 1

First, from the reordered list, we can find the last half of the list is changed to 
backward. So, we need to reverse a right half of the list. To find a half of the list,
we can use two cursors that move one node on each loop and move one node on each two
loop. Then, the second cursor will be moved to a half of the list, and we can find a
number of nodes in the array by the first cursor. After then, we can reverse a right half
of the list from the second cursor.

Next, we need to reorder the list as the given way. We already have `L0` and `Ln` node
while reverse a right half of the array. So, we can just insert a right half of the list
to a left half of the list.

A time complexity is O(n) because we just traverse the list first to reverse a right half
of the array, and traverse the list again to insert a right half to a left half.  
A space complexity is O(1) because we don't save any history or information in a memory
and just use two cursors.

- Time complexity: O(n)
- Space complexity: O(1)
