# Combination Sum

## Problem

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

## Input

Integer array that contains distinct integers, a target integer `target`

## Example

- Example 1:

>Input: candidates = [2,3,6,7], target = 7  
Output: [[2,2,3],[7]]  
Explanation:  
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.  
7 is a candidate, and 7 = 7.  
These are the only two combinations.

- Example 2:

>Input: candidates = [2,3,5], target = 8  
Output: [[2,2,2,2],[2,3,3],[3,5]]

- Example 3:

>Input: candidates = [2], target = 1  
Output: []

## Constraints

- 1 <= candidates.length <= 30
- 1 <= candidates[i] <= 200
- All elements of candidates are distinct.
- 1 <= target <= 500

## Output

All the unique combinations of candidates that's sum is the target. All the numbers can be used unlimited number of times.

## Solution 1

First, we need to sort the given candidates array as ascending order.  
Next, we can start to build a current combination from the smallest candidate.  
Next, we can select a next number from the current item.
If the sum is smaller than the target, we can repeat to add a candidate again.
If the sum is same with the target, we can add it to the combinations and pop the top of a stack.  
If the sum is larger than the target, we can pop the two top items and add a next candidate.
Repeat this thing until we search all the candidates, we can find all the candidates without any duplicates
because we always add a new candidate same or larger with a current item.
So, it could not find the same item can be made with the previous candidates.

A time complexity is O(n^2) because we find the candidates like a bubble sort.  
A space complexity is O(target) because a length of a stack can be the target in the worst case that filled by 1 until the target. 

- Time complexity: O(n^2)
- Space complexity: O(target)
