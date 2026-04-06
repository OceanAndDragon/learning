# 113. Path Sum II

#### Link: https://leetcode.com/problems/path-sum-ii/description/

## Approach
### 1. **DFS + Backtracking**
#### General idea: We maintain 1) a list of integers representing the current path, and 2) an integer representing the running sum. At each node, 1) we will add the current node value to the path and update the sum. 2) if the node is a leaf node, check if the running sum equals to the target and deep copy the current path to the result list if running sum is equal to target.
#### Then, recursively explore left and right subtrees. After exploring, we will remove the current node from the path **(Backtracking)**.
--- 