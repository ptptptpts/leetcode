# Course Schedule

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

## Input

Number of courses and a list of prerequisites

## Example

- Example 1:

>Input: numCourses = 2, prerequisites = [[1,0]]  
Output: true  
Explanation: There are a total of 2 courses to take.  
To take course 1 you should have finished course 0. So it is possible.  

- Example 2:

>Input: numCourses = 2, prerequisites = [[1,0],[0,1]]  
Output: false  
Explanation: There are a total of 2 courses to take.  
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

## Constraints

- 1 <= numCourses <= 2000  
- 0 <= prerequisites.length <= 5000  
- prerequisites[i].length == 2  
- 0 <= ai, bi < numCourses  
- All the pairs prerequisites[i] are unique.  

## Output

True if we can take all the courses

## Solution 1

Basically, if we don't have any prerequisites, we can take all the
courses. And, even if we have a lot of prerequisites, we can take them
all if they don't have a cycle because basically we can take all the 
courses. So, we can change a problem to find a cycle from a trie.

First, we can assume a prerequisite mean a parent and child of a trie,
and we need to save them in a list of parent of each course.
After saving all the prerequisites, we can find a cycle from all the
tries.

To find a cycle, we can use a HashSet or array to mark a visited course
of a current trie. We can mark a current course as '1' to check it as
visited, and mark a course we can take as '-1'. If current course has
a parent marked as '1', it finds a cycle. Or, if a current course has
a parent marked as '0', it finds a new course that needs to check. If
a current course has a parent marked as '-1', this prerequisite can be
removed. If a current course has no prerequisite after checking all its
parent, we can take this course.

- Time complexity: O(n * m)
- Space complexity: O(n)
