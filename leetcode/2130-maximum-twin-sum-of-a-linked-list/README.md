# 2130. Maximum Twin Sum of a Linked List

#### Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

## Approach
### 1. **Stack**
#### General idea: With two pointers, we can read the first half nodes and while we are traversing, we insert value of node into stack. When we traverse the second half of nodes, we pop out the value from stack and get the sum by adding current value. Then, we can check if this is ***maxSum*** or not.
---
### 2. **Reverse List**
#### General idea: Similar with Approach #1, we traverse the first half nodes with two pointers but we will reverse the first half nodes. Then when we traverse the second half nodes, we can get both values and keep track of the ***maxSum***.
--- 