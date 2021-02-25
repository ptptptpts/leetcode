# Move Zeroes

## Problem

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

## Input

Integer Array

## Constraints

None

## Output

None, change on the input array.

## Solution 1

Make a cursor and copy each integer from i to cursor.  
If the i-th integer is not zero, copy the i-th integer and move cursor to next one.  
If the i-th integer is zero, skip the i-th integer.  

After checking all the integers, fill the zero from cursor to end of the input array.

- Time complexity: O(n)
- Space complexity: O(1)
