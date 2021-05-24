# Max Points on a Line

## Problem

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

## Input

2 dimension integer array that describes xi and yi on each item.

## Example

Example 1:

Input: points = [[1,1],[2,2],[3,3]]  
Output: 3  

Example 2:

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]  
Output: 4

## Constraints

- 1 <= points.length <= 300
- points[i].length == 2
- -10^4 <= xi, yi <= 10^4
- All the points are unique.

## Output

Integer, the maximum number of points that lie on the same straight line.

## Solution 1

If we have three points, we can find they are on a straight line or not by comparing a slope of the line.

For example, lets assume we have three points p1(x1, y1), p2(x2, y2), and p3(x3, y3).  
We can find a slope between p1 and p2 by (y1 - y2) / (x1 - x2).  
If the p3 is on the straight line with p1 and p2, a slope between p1 and p3 will be same with the slope between p1 and p2.  
So, if p1, p2, and p3 satisfy the below function, they are on the same straight line.

f(p1, p2, p3) = (y1 - y2) / (x1 - x2) - (y1 - y3) / (x1 - x3)

However, we can't this function directly because we are in integer domain.  
So, we can convert the function by the below compare statement.

> If (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2), the p1, p2, and p3 are in the same straight line.

The Time complexity is O(n^3), because it make a straight line in all pairs and compare it with all points in array.

The Space complexity is O(1), because it saves only a number of the maximum cross points by the straight line.

- Time complexity: O(n^3)
- Space complexity: O(1)

## How to improvement

If the p1, p2, and p3 are in the same straight line, we don't need to compare them on the further loop.  
So, we can save all the points in the linked list, and remove the points that we already find from the other straight line.  
This will reduce a number of points we need to compare in loop, but still Time complexity is O(n^3) in the worst case.

## Solution 2

Let's assume we compare all the slopes from p1 and the other points.  
Because we have a static point p1, the points that have the same slope will on the same straight line.  
So, we can check all the straight lines by repeating this job in all the points in the input.  
In each loop, we need to save each slope to count a number of points have the same slope.

Moreover, because the straight line that contains the previous point is already checked by the previous point, we can check all the points next after a current static point.

The Time complexity is O(n^2), because it checks all slopes between each points.

The Space complexity is O(n), because we need to save the slopes on each points in each loop.

- Time complexity: O(n^2)
- Space complexity: O(n)
