# Insert Interval

## Problem

You are given an array of non-overlapping intervals `intervals` where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

## Input

One array that contains an integer array with two elements start and end of each interval.  
The other one is an integer array with two elements that represents a new interval.

## Example

- Example 1:

>Input: intervals = [[1,3],[6,9]], newInterval = [2,5]  
Output: [[1,5],[6,9]]

- Example 2:

>Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]  
Output: [[1,2],[3,10],[12,16]]  
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

## Constraints

- 0 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= start i <= end i <= 10^5
- intervals are sorted by start i in ascending order.
- newInterval.length == 2
- 0 <= start <= end <= 10^5

## Output

A list of intervals after merge the new interval.

## Solution 1

A start of new interval can be located in the three cases while searching from start to end of intervals.

First, smaller than start of a current interval.
In this case, we can assume a new interval can be located in here because all the previous intervals
are larger than a new interval. And, a start will be updated to a new interval.

Seconds, larger or equal than a start of a current interval, but smaller or equal than an end of a
current interval. In this case, we can assume a new interval can be located in here, but a start is
same as before.

Last, larger than an end of a current interval. We can assume a new interval is larger than a
current interval and move to the next one. 

An end of new interval can be located in the three cases like this.

First, smaller than a start of a current interval. A new interval is finished before a current interval.
So, it could be ended with an end of a new interval.

Seconds, larger or equal than a start of a current interval, but smaller or equal than an end of a
current interval. A new interval will be merged with a current interval. A new interval will be
ended with an end of a current interval.

Last, larger than an end of a current interval. We can move to a next interval. 

A time complexity is O(n) because we need to search all the intervals.  
A space complexity is O(1), because we don't need to save anything in a memory.

- Time complexity: O(n)
- Space complexity: O(1)
