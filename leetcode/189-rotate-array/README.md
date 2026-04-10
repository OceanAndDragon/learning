# 189. Rotate Array

#### Link: https://leetcode.com/problems/rotate-array/description/

## Approach
### 1. **Cycle Replacements**
#### General idea: First, we normalize `k` by performing `k %= n`, and return immediately if `k == 0`. Use a `start` pointer to track the beginning of each cycle, and two variables `curr` and `next` to traverse and shift each element to its correct position `(curr + k) % n`. Repeat this process `n` times to ensure every element is moved to correct positions.
#### In each step, we perform:
1. Compute `next = (curr + k) % n` and move the current value to the computed index.
2. If a cycle detected, where `next == start`, increment `start` and begin a new cycle from there.
--- 
### 2. **Reverse List**
#### General idea: We can also accomplish array rotation by performing reverse 3 times.
#### Example: `nums = [1,2,3,4,5,6,7], k = 3`
1. Reverse the whole list. => `[7,6,5,4,3,2,1]`
2. Reverse the list from `0` to `k - 1`. => `[5,6,7,4,3,2,1]`
3. Reverse the list from `k` to `end`. => `[5,6,7,1,2,3,4]`
--- 