# 3Sum

## Problem

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

## Input

Integer array

## Example

- Example 1:

>Input: nums = [-1,0,1,2,-1,-4]  
Output: [[-1,-1,2],[-1,0,1]]

- Example 2:

>Input: nums = []  
Output: []

- Example 3:

>Input: nums = [0]  
Output: []

## Constraints

- 0 <= nums.length <= 3000
- -10^5 <= nums[i] <= 10^5

## Output

List that contains a List of integer. This integer list contains a triplet their sum is 0.

## Solution 1

This problem does not allow to contains duplicat triplets. So, first we need to find a condition that can create a triplet without any duplicates.  

First, if a list contains three zeros, we can make a triplet as 0, 0, and 0.  
Seconds, if a list contains a zero, we can make a triplet by one negative, 0, and one positive.  
Thirds, if we select two same negative or positive, we can make a triplet by two same negative(positive) and one positive(negative).  
Fourth, if we select one negative and positive, we can make a triplet by one negative, one positive, and remains if it is exist.  

To find the first condition, we need to count a number of zeros.  
To find the second condition, we need to count a number of zeros, and save a negative and positive as a different data structure. To find the other side one easily, HashSet is the best one because we can find the target as O(1) cost.  
To find the third condition, we need to duplicated numbers from the given array. Because the others are not duplicated one, we can save the duplicates as a list and find the remains from the HashMap we made in the second condition.  
To find the fourth condition, we need to search both the negative and positive HashSet made in the second condition. However, it can find the same triplet again when it visit a remain, we need to save a visited integer in the others and ignore a remain if it is in a visited. To find a remain is visited or not easily, a HashSet is the best data structure.

A time complexity is O(n^2) because it need to traverse all the positive integers on each negative integer at the fourth condition.  
A space complexity is O(n) because it need to save negatives and positives in a HashSet.

- Time complexity: O(n^2)
- Space complexity: O(n)

## Solution 2

We can find the triplets by a window without any additional memory.  
Let's assume the given array is sorted. Then, it guarantee the `i`th integer is larger than any behinds from `i`. It means, any triplets with the `i`th integer as the minimal one is not duplicated. We can traverse the given array with this rule.  
Next, we can use two windows to find a triplet that made a sum as 0. A left starts from a next of `i`, and a right starts at the end of array. If a sum of triplet is smaller than 0, it means a right window is too high. So, we can move a right window to left. If a sum of triplet is larger than 0, it means a left window is too low. If a sum of triplet is 0, this triplet can be in a result. However, a left or right window can point the same integer at the next position. So, we need to move them until they meet a different integer. At last, the minimal can be same number even if we move it the right. So, we need to skip a current minimal if it is same with the previous.

A time complexity is O(n^2) because we traverse the given array with the minimal and search a remianed array by a window.  
A space complexity is O(1) because we don't need to save something without a return.

- Time complexity: O(n^2)
- Space complexity: O(1)
