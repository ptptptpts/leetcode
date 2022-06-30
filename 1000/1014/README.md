# Best Sightseeing Pair

## Problem

You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

## Input

Integer array

## Example

- Example 1:

>Input: values = [8,1,5,2,6]  
Output: 11  
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

- Example 2:

>Input: values = [1,2]  
Output: 2

## Constraints

- 2 <= values.length <= 5 * 104
- 1 <= values[i] <= 1000

## Output

The best sightseeing score between two pairs in the given array.

## Solution 1

A function to find a sightseeing score is defined as a sum of score in two position minus a distance between two positions. So, it can be defined as the below function f(i, j) when i < j.

>f(i, j) = (values[i] + values[j]) - (j - i) = values[i] + i + values[j] - j

In this function, variables related with `i` can be fixed as the best one while traverse the given array, and only variables related with `j` can be changed as a current value.  

A time complexity is O(n) because we traverse the given array only once.  
A space complexity is O(1) because we save only the best `i` and the best sightseeing score.

- Time complexity: O(n)
- Space complexity: O(1)
