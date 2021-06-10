# My Calendar I

## Problem

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

## Input

book(int start, int end)

## Example

Example 1:

MyCalendar();  
MyCalendar.book(10, 20); // returns true  
MyCalendar.book(15, 25); // returns false  
MyCalendar.book(20, 30); // returns true  

Explanation:  

The first event can be booked.  The second can't because time 15 is already booked by another event.  
The third event can be booked, as the first event takes every time less than 20, but not including 20.

## Constraints

- The number of calls to MyCalendar.book per test case will be at most 1000.
- In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

## Output

Return true if it can be added to the calendar

## Solution 1

First, manage the events by arraylist as sorting by start date.

When book is called, start to check the input event from the saved events.

If the end date is later than a start date of the input event, compare with a next event.  
If the start date is eariler than an end date of the input event, return false because it is overwrapped.  
If not, we can add the input event on the current position.

The time complexity is O(n) because it need to compare with all the previous events in the worst case.

The space complexity is O(n) because it need to save an event in input array when it called.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Improving from the solution 1, we can update the compare logic more simplified one.

Two events are not overwrapped if an end date is eariler than a start date of the other one.  
Because we don't know which event finishes eariler than the other one, we can compare the minumum end date with the maximum start date like this.  

- max(start1, start2) >= min(end1, end2)

So, we can compare the input event with the all the saved events by the upper condition, and save the input event if it pass the upper condition on the all the saved events.
