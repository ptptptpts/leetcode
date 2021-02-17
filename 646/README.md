# Rotate Array

## Problem

Given an array, rotate the array to the right by k steps, where k is non-negative.

## Input

Integer Array, Integer k  
  
## Constraints

- 1 <= nums.length <= 2 * 104
- -231 <= nums[i] <= 231 - 1
- 0 <= k <= 105

## Output

1) Rotate the given array

## Solution

Let's assume n is 7 and k is 3.  
>nums = [1,2,3,4,5,6,7], k =3

The output will be like this.
>[5,6,7,1,2,3,4]

The integers below and equal with 4 is moved to right position.  
And the integers larger than 4 is moved to left position.

Let's describe this logic by mathmatical function.  

The i-th integer inside of n-k will be moved to i+k th position.  
We can describe it like this.  
>f(i) = i+k, (i is i < n-k)

And, if we reverse an array of size n, the i-th integer will be moved to n-i.  
We can define this function as "r(n, i) = n-i"  
We can modify the previous function by this reverse function.  
>f(i) = i+k, (i is i < n-k)  
= n-n+i+k  
= n-(n-i-k)  
= r(n, n-i-k)  
= r(n, n-k-i)  
= r(n, r(n-k, i))  

In conclusion, we can move the i-th integer in (i < n-k) range by  

1) Reverse integers from 0 to n-k range.
2) Reverse integers from 0 to n range.

Next, if the i-th integer outside of n-k will be moved to i+k-n th position.  
We can describe it like this.  
>f(i) = i+k-n, (i is i >= n-k)

To make this function to simple one, let's change i as the other integer starting from 0.  
Because i is larger and equal with n-k, we can describe it as j like this.
>i = n-k+j, (i is i >= n-k, j is k > j >= 0)  

And, let's describe the f(i) as a reverse function like the previous logic.
>f(i) = i+k-n, (i is i >= n-k)  
= n-k+j+k-n, (j is k > j >= 0)  
= n-(n-k+k-j)  
= r(n, n-k+k-j)  
= r(n, n-k+ r(k, j))

In conclusion, we can move the i-th integer in (i >= n-k) range by

1) Reverse integers from n-k to n range.
2) Reverse integers from 0 to n range.

Now, we can move the integers in both range that divided by n-k like this.

1) Reverse integers from 0 to n-k range.
2) Reverse integers from n-k to n range.
3) Reverse integers from 0 to n range.

- Time complexity: O(n), loop 2 times
- Space complexity: O(1)
