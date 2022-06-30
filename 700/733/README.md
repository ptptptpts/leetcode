# Flood Fill

## Problem

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

## Input

Two dimension integer that filled by some integer value.  
Three integer sr, sc, and newColor. `sr` and `sc` represent a point of the given array. `newColor` represent a new color that will update in image[sr][sc]

## Example

- Example 1:

>Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2  
Output: [[2,2,2],[2,2,0],[2,0,1]]  
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.  
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

- Example 2:

>Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2  
Output: [[2,2,2],[2,2,2]]  

## Constraints

- m == image.length
- n == image[i].length
- 1 <= m, n <= 50
- 0 <= image[i][j], newColor < 2^16
- 0 <= sr < m
- 0 <= sc < n

## Output

The image updated by the flood fill at the image[sr][sc]

## Solution 1

We can search the array by the queue.  
Before starting searching, we'll push the starting point in the queue.  
Next, we'll pop the queue until it is empty, and compare all the next elements with a current element.
And, if any element is same with a current element, we'll push it to the queue.
After then, we'll update a current element as a new color.

However, we can visit the same element again because we don't check the visited cell.
To find the visited cell, we can use one of the solution, the first one is mark the visited cell in the array.
Next one is saving the visited position as a HashSet.
I think the first solution is good to use the given array because an element has only the positive value.
So, we can mark the visited cell as -1, and updating them after searching all the queue.

In conclusion, we can find the updated cell by the below order.

1) Push the starting point in the queue.
2) Pop the queue until a cell is not -1
3) Compare the next cells with a current element, and push the cells with the same value.
4) Update the current cell as -1
5) If the queue is not empty, go to the step 2.
6) Updating all -1 as a new color

A time complexity is O(m*n) because we need to find all the elements in the worst cases.  
A space complexity is O(m*n) because we need to save all the elements to the queue in the worst cases.

- Time complexity: O(m*n)
- Space complexity: O(m*n)
