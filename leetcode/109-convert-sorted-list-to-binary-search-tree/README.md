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
#### General idea: Instead of finding the `mid` every time, we can use the **In-order Traversal**.
#### First, we will find the total length of the list node.
#### Then, by having 0 as left limit and length - 1 as right limit, we can construct the BST using **In-order Traversal**.
* Have global linked list pointer `gHead`.
* Base case: if start is greater than the end, then we return null.
1. Find the `mid` with `start + (end - start) / 2`.
2. Construct left subtree from `start` to `mid - 1`.
3. Set current node as root node.
4. Move `globalHead` pointer by 1.
5. Construct right subtree from `mid + 1` to `end`.
--- 