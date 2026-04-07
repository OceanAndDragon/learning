# 437. Path Sum III

#### Link: https://leetcode.com/problems/path-sum-iii/description/

## Approach
### 1. **Prefix Sum + Map**
#### General idea: Since each node at a tree can be a start of the path, we need to maintain a map, `prefixCounts`, which will have ***prefix sum*** of each node, so we can keep counts of each prefixes and get the counts if we meet the node that satisfies the prefix. The idea is simple. From the root, we put the count of `targetSum + currSum` to the `prefixCounts`. Then we calculate current value by `currSum + node.val`. If current value is in the map, we get the count, then repeat this process as we go down the tree. Finally, we need to decrement the count of current ***prefix sum*** before we return the count.
--- 