# Plus One

## Problem

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

## Input

Integer array

## Constraints

- 1 <= digits.length <= 100
- 0 <= digits[i] <= 9

## Output

Return the elementn which appears only once.

## Solution 1

Starting from the last digit and add one.
If the element is 10, change it to 0 and add one to the next one.

Because the length of digits can be increased, add it first on the input digit and copy it to the new digits array with the updated MSD.

- Time complexity: O(n)
- Space complexity: O(1)
