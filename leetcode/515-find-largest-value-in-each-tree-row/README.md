# 515. Find Largest Value in Each Tree Row

#### Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

## Approach
### 1. **DFS + Recursion**
#### General idea: Each row represents the depth of each node. We can track the current depth using DFS. If the depth `i` is equal to the size of the list, then this is the first node we visit at depth `i`, so we add the current node value to the list. As we visit other nodes at the same depth, we update the value at index `i` with the maximum between the current node value and the existing value.
* Base case: if current node is null, return.
* if current depth is equal to the size of the result list, put current value to the result list.
* if current root value is larger than the value at the current depth, replace the value
* recursively repeat above process for left subtree and right subtree and set the depth to `i + 1`.
--- 
### 2. **BFS**
#### General idea: To be updated
---