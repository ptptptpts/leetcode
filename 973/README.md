# K Closest Points to Origin

## Problem

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

## Input

Array of points, and an integer K

## Example

- Example 1:

>Input: points = [[1,3],[-2,2]], k = 1  
Output: [[-2,2]]  
Explanation:  
The distance between (1, 3) and the origin is sqrt(10).  
The distance between (-2, 2) and the origin is sqrt(8).  
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.  
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

- Example 2:

>Input: points = [[3,3],[5,-1],[-2,4]], k = 2  
Output: [[3,3],[-2,4]]  
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

## Constraints

- 1 <= k <= points.length <= 10^4
- -10^4 < xi, yi < 10^4

## Output

Array of points the k closest points from the origin (0,0)

## Solution 1

We can save the points in the PriorityQueue(Heap) to save them in an order of the closest one.
In this case, we can put each point by O(logn) cost, and pop k items by O(logn) cost.
And we need to save all the points to a Heap, and it can use an unnecessary memory if k is very
small than a number of points.

A time complexity is O(nlogn) because we need to save all the items in a Heap.  
A space complexity is O(n) because we need to save all the items in a Heap.

- Time complexity: O()
- Space complexity: O(1)
