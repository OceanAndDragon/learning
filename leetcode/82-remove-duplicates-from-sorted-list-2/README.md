# 82. Remove Duplicates from Sorted List 2

#### Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

## Approach
### 1. **Iteration**
#### General idea: Keep two pointers ***prev***, ***curr*** and one boolean flag ***isDuplicate***. If ***curr*** and ***curr.next*** have same value, set ***isDuplicate*** to ***true*** and keep skipping duplicates by setting ***curr.next*** to ***curr.next.next***. If we reached to non-duplicate value, set ***isDuplicate*** to ***false***, then move ***curr*** to its next and update ***prev.next*** to moved ***curr*** node to skip the last duplicate node. Repeat this process until we reaches to the end.
* Need to check if ***isDuplicate*** still sets to ***true*** after the iteration to check if the last group of nodes are duplicates.
--- 