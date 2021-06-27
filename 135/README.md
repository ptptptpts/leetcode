# Candy

## Problem

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.

## Input

An integer array with size of n that describes a rating value of each children.

## Example

Example 1:

Input: ratings = [1,0,2]  
Output: 5  
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.  

Example 2:

Input: ratings = [1,2,2]  
Output: 4  
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.  
The third child gets 1 candy because it satisfies the above two conditions. 

## Constraints

- n == ratings.length
- 1 <= n <= 2 * 10^4
- 0 <= ratings[i] <= 2 * 10^4

## Output

The minimum number of candies you need to have to distribute the candies to the children.

## Solution 1

We can assume an input array like a 2D line graph that describes a rating value of each children. On each upward slope, a current child need more candies from the previous child. On each downward slope, a previous child need more candies from the current child. So, we can change this problem by finding a number of maximum continous slope on each item.

To find a number of the maximum continous slope on each item, we can count upward slope by traverse left to rigth and compare the i th item with the i-1 th item. Also, we can find a number of downward slope by traverse right to left and compare the i th item with the i+1 th item.

When we traverse left to right, we can count a slope by saving a length of slope on array. And when we traverse right to left, we can overwrite a length of slope if a current slope is higher than the upward slope on a current item. If an upward slope of a current item is higher than a downward slope, we shouldn't overwrite it because it is a peak.

The time complexity is O(n) because it traverse an input array two times from left to right, and from right to left.

The Space complexity is O(n) because it saves a number of candies on each child.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Like the solution 1, let's assuem an input array as a 2D line graph, and find the longest slope on each position.

First, we can find the end of slope if a current slope is a flat ground. In this position, we don't need to care about the previous position.

Seconds, if a current continuous slope has only upward slope, the total height of current slope is a sum from 1 to a length of slope.

Thirds, if a current continuous slope has only downward slope, the total height of current slope is a sum from 1 to a length of slope.

At last, if a current continuous slope has both upward and downward slope, the total height of current slope is a sum from 1 to a length of upward slope and from 1 to a length of downward slope. Also we should minus a shorter slope because a current slope has only one peak.

The Time complexity is O(n) because it traverse an input array only once and find a number of candies on each child on time.

The Space complexity is O(1) because it calculate a number of candies on each child on time.

- Time complexity: O(n)
- Space complexity: O(1)
