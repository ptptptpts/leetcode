# Contains Duplicate

## Problem

Given an array of integers, find if the array contains any duplicates. 

## Input

Integer array

## Constraints

None

## Output

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

## Solution 1

Sort array and compare each item with the next item.  
If the item is same with the next one, the input array has a duplicates.

- Time complexity: O(nlogn) (Sort cost)
- Space complexity: O(1)

## Solution 2

Put all the items to hash set and find any duplicates.

- Time complexity: O(n)
- Space complexity: O(n) (Hash cost)
