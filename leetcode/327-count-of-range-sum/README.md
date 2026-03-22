# 3. Count of Range Sum

#### Link: https://leetcode.com/problems/count-of-range-sum/description/

## Approach
### 1. **Brute Force**
#### General idea: We use two nested loops to enumerate all possible subarrays. The outer loop selects the starting index i, and the inner loop extends the subarray to index j. While iterating, we maintain a running sum of the current subarray. For each subarray, we check whether the sum lies between lower and upper, and increment the count if it does.
---
### 2. **Prefix Sum + Merge Sort**
#### General idea:
--- 