# 235. Lowest Common Ancestor of a Binary Search Tree

#### Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

## Approach
### 1. **Binary Search Tree**
#### General idea: The idea is simple. Since we are dealing with binary search tree, we don't need to look at all nodes of the tree.  We will use ordering property of binary search tree to find lowest common ancestor. First, we have the **min** and **max** values between ***p*** and ***q***. While we are traversing, if we reach the node current ***root*** value is in between **min** and **max**, we are at the **LCA**, so return the node. If the current ***root*** value is greater than the **max**, we don't need to go to ***right***, since ***p*** and ***q*** will be in the ***left*** subtrees. Likewise, if the current ***root*** value is less than the **min**, we don't need ***left*** subtrees.
--- 