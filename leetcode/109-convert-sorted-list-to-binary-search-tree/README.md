# 109. Convert Sorted List to Binary Search Tree

#### Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

## Approach
### 1. **Divide and Conquer + Two Pointers on Linked List**
#### General idea: We need to find the `mid` point of the linked list and set the `mid` as a `root`, then make left part of the list as left subtree and make right part of the list as right subtree. To find the `mid` point, we can use two pointers: a `slow` pointer, which moves by 1 node and a `fast` pointer, which moves by 2 nodes. When the pointers reach the middle, `slow` will be at the `mid`. We then split the list into two halves by disconnecting the node before `mid`. After that, we recursively apply the same process to the left part and the right part of the list to construct the BST.
* Base case:
    1. if current node is null, return null.
    2. if the next node of current node is null, then current node is the leaf node. We simply return TreeNode with current node value.
--- 
### 2. **Divide and Conquer + In-order Traversal**
#### General idea:
--- 