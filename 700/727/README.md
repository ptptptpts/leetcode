# Remove Duplicates from Sorted Array

## Problem

Remove duplicated number from given array.
Array is sorted.

## Input

Integer Array  
  
## Constraints

0 <= nums.length <= 3 * 104  
-104 <= nums[i] <= 104  
nums is sorted in ascending order.  

## Output

1) Remove duplicated numbers from given array.
2) Return a number of integers remained in the given array.

## Solution

1) The given array is already sorted. So, we can find a duplicated number by comparing it with the next number.  
   If the number is same with the next one, it is duplicated one.
2) If a number is duplicated, we can overwrite it by the next not-duplicated number.
3) So, we can use a cursor to point current position and move it to the next one if this number is not duplicated.
4) If the i-th number is not duplicated, copy it to cursor position and increase the cursor.
   Else if the i-th number is duplicated, ignore it and move the next number.
5) The first number shall not be removed because it is the oldest number in this array. So, we can start a loop from 1 to end.