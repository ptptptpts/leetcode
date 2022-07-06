# Majority Element

## Problem

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [3,2,3]  
Output: 3

- Example 2:

>Input: nums = [2,2,1,1,1,2,2]  
Output: 2

## Constraints

- n == nums.length
- 1 <= n <= 5 * 10^4
- -10^9 <= nums[i] <= 10^9

## Output

The majority element

## Solution 1

Because a range of an element is Integer, so we can't use an array to
count a number of each integer. Instead of an array, we can use a HashMap
to count each number.

A time complexity is O(n) because a cost to find a specific number from
HashMap is O(1) and we need to search all the elements in the give
array.  
A space complexity is O(n) because we need to save all the elements in
the array to count them.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

If integer `a` is the majority element, it means a number of the other
integers is less than a number of integer `a`. So, if we count a number
of some integer and decrease a counter if a current number is not it, a
counter will be positive only if the number is the majority element. To
expand this logic to all the elements, we can select a current element as
the one which can be the majority element and increase a counter if we
met the same integer. And, we can decrease a counter if we met the
different integer, and replace a current integer if we met the different
integer when a counter is 0. If a counter is 0, it means a number of the
other integers is higher than a number of current integer. So, it means
a current integer could not be the majority element.

A time complexity is O(n) because we need to search all the elements in
the array.  
A space complexity is O(1) because we save a current element and counter
of it.

- Time complexity: O(n)
- Space complexity: O(1)
