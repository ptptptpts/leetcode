# Course Schedule II

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

## Input

Number of courses and a list of prerequisites.

## Example

- Example 1:

>Input: numCourses = 2, prerequisites = [[1,0]]  
Output: [0,1]  
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

- Example 2:

>Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]  
Output: [0,2,1,3]  
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.  
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

- Example 3:

>Input: numCourses = 1, prerequisites = []  
Output: [0]

## Constraints

- 1 <= numCourses <= 2000
- 0 <= prerequisites.length <= numCourses * (numCourses - 1)
- prerequisites[i].length == 2
- 0 <= ai, bi < numCourses
- ai != bi
- All the pairs [ai, bi] are distinct.

## Output

A way to take all the courses, and an empty array if we can't take all the courses. 

## Solution 1

First, we need to make a list of courses that need to take this course first to take
that course. With this, we can find a new courses that we can take at the next loop.
Next, we need to have a list of prerequisites at each course to find that we can take
this course or not at this loop.

Let's assume we have these kinds of data structure. First, we can take all the courses
that does not have any prerequisites, and remove them from the courses that have these
courses as a prerequisite. After then, we can find new courses that we can take after
taking the previous courses. And, we can repeat them until we take all the courses or
take all the available courses. If there are some courses are remained even we can't take
any other courses again, we can't take all the courses with the given values. If we take
all the courses, we can return an array of courses we take.

A time complexity is O(n^2) at the worst case, if all the courses have each other as a
prerequisites.  
A space complexity is O(n^2) at the worst case, if all the courses have each other as a
prerequisites.

- Time complexity: O(n^2)
- Space complexity: O(n^2)
