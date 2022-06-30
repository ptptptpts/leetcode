# Ugly Number II

## Problem

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

## Input

Integer N

## Example

- Example 1:

>Input: n = 10  
Output: 12  
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

- Example 2:

>Input: n = 1  
Output: 1  
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

## Constraints

- 1 <= n <= 1690

## Output

Nth ugly number

## Solution 1

Finding a ugly number from 1, and save a ugly number to HashSet. If `i` can be divided by 2 or 3 or 5 and it is in the HashSet, `i` is a ugly number.  
This solution is really slow because it traverse from 1 to ugly(n).  

A time complexity is O(n) because a searching range is depends on how `n` is large. But, its real cost is very high because its searching range depends on ugly(n).  
A space complexity is O(n) because it save all the ugly number to HashSet.

- Time complexity: O(n)
- Space complexity: O(n)

## Solution 2

Instead of finding a ugly number by increasing `i`, we can create a new ugly number by multiply 2 or 3 or 5 from the previous ugly number. Using a priority queue, we always can get the smallest ugly number we found and find the next ugly numbers by multiply 2, 3, and 5. To prevent a duplicate ugly number, we need to save a visited ugly number in a HashSet.  

A time complexity is O(nlogn) because we have a cost to push a new ugly number to a priority queue by O(logn) and repeat this logic on all the `n`.  
A space complexity is O(n) because we need to save all the ugly numbers in a HashSet or priority queue.

- Time complexity: O(nlogn)
- Space complexity: O(n)

## Solution 3

We can define a ugly number as a multiple of a factor of two, three, and five. It means we can find the smallest ugly number can be made by multiply 2 from some base, and we can do the same thing also in 3 and 5. For example, all the ugly numbers starts from 1. So, all the cursors starts from 0. Then, we can calculate new candidates by multiply 2, 3, and 5 from each base, and find the minimal value as a new ugly number.  
Some ugly number like 6 or 30 can be found on multiple factors at the same time. It means we need to move multiple cursors on some ugly numbers. We can save and find those numbers by using HashSet, but there are simpler way based on a specific of this solution. In this solution, all the two, three, and five factors points the minimal ugly numbers can be made by multiply two, three, or five. It means, they always point the minimal value and they will point the same number if a current ugly number can be made by multiple factors.

A time complexity is O(n) because it generate a new ugly number by comparing three digits.  
A space complexity is O(1) because we save only a cursor for 2, 3, and 5 factor and their values.

- Time complexity: O(n)
- Space complexity: O(1)
