# 218. The Skyline Problem

#### Link: https://leetcode.com/problems/the-skyline-problem/

## Approach
### 1. **Sorting + Max Heap**
#### General idea: Keep the points sorted in ascending order of x. Add a point to the final result whenever there is a change in the maximum height of the buildings.
* **Tie breaker**: If multiple points have the same x value, consider the following:
    * **Start point always comes before the end point:**
        * If the end point comes first, it may incorrectly update the max height and add an invalid point to the result.
        * To handle this, represent the height of a start point as a negative value
    * **Greater height comes before smaller height**
* **Max Heap**: Maintain heights in descending order:
    * **Start point**: insert height
    * **End point**: remove height
        * Keep track of the current maximum height (top of heap). If it changes after the above operations, add the current point to the result.
---
### 2. **Binary Search**
#### To be updated
--- 