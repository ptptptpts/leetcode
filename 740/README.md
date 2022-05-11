# Delete and Earn

## Problem

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

- Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.

Return the maximum number of points you can earn by applying the above operation some number of times.

## Input

Integer Array that contains a point in each position.

## Example

- Example 1:

>Input: nums = [3,4,2]  
Output: 6  
Explanation: You can perform the following operations:
>
>- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].  
>- Delete 2 to earn 2 points. nums = [].
>You earn a total of 6 points.

- Example 2:

>Input: nums = [2,2,3,3,3,4]  
Output: 9  
Explanation: You can perform the following operations:  
>
>- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
>- Delete a 3 again to earn 3 points. nums = [3].
>- Delete a 3 once more to earn 3 points. nums = [].
>
>You earn a total of 9 points.

## Constraints

- 1 <= nums.length <= 2 * 10^4
- 1 <= nums[i] <= 10^4

## Output

The maximum point can be granted from the given array.

## Solution 1

First, because each integer affects each other by its size, not a location, we need to read entire array and sort and count them first. To easily count and search them, saving them in array is the best. So, we need to create a size of array that can contain the maximum value of nums[i] and count how many each number is appeared in the array.  

Next, we can convert this problem as a sum of local maximum points. For example, if some integer `n` is not appeared in the array, we can assume the array is divided by two sections before and after the integer `n`, because `n-1` and `n+1` can't affect each other.  

Next, we can calculate the maximum point at an integer `n` as the below function. `f(n-1)` is ignored because we can move to `f(n)` from `n-2` or `n-3`.  

>f(n) = Max(f(n-2), f(n-3)) + (n * count(n))

Finally, we can find the solution by the below way while traverse a count array from 1 to the maximum of nums[i].  

1) Initialize a point array as '0' and a positive number counter as '0'. The point array contains the maximum point at the last four integers.
2) If count[i] is larger than 0, find the maximum point at `i` as `Max(point[i-2], point[i-3]) + (i * count[i])`. And increase a positive number counter.
3) If count[i] is 0 and a positive number counter is larger than 0, reset a positive counter and initialize a point array as the maximum point `Max(point[i-1], point[i-2])`.
4) If we finish to traverse a count array, the maximum point is `Max(point[i], point[i-1])`.

A time complexity is O(Size of nums + Maximum of nums[i]), because we need to traverse the given array at least once to count each integer and traverse a count array again to find the solution.  
A space complexity is O(Maximum of nums[i]), because we need to count each integer by an array with a size the maximum of nums[i].

- Time complexity: O(Size of nums + Maximum of nums[i])
- Space complexity: O(Maximum of nums[i])
