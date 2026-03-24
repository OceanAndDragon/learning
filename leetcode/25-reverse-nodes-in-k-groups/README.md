# 25. Reverse Nodes in K Groups

#### Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

## Approach
### 1. **Iteration**
#### General idea: Find ***g***, where ***g*** is number of groups in list nodes by counting the number of nodes and divide it by k. Then we can reverse list node with ***g*** iteration.
* Keep two pointers ***prev*** and ***curr***, where ***curr*** is current pointer and ***prev*** is previous pointer.
* **Outer loop**: From 0 < i < g:
    * **Inner loop**: From 1 < j < k:
        1. prev.next -> curr.next
        2. curr.next.next -> prev.next
        3. curr.next -> curr.next.next
        * Need to store in temp vars of each pointers before assign them.
    * Assign prev as curr, and move curr to next, and repeat
--- 