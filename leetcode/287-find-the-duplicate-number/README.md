# 287. Find the Duplicate Number

#### Link: https://leetcode.com/problems/find-the-duplicate-number/description/

## Approach
### 1. **Brute Force**
#### General idea: Use nested loops to find all combination. If ***i*** and ***j*** are not equal but the vals are equal, we found the duplicate.
---
### 2. **Set**
#### General idea: Use Set to find duplicate. Put each ***nums[i]*** to set while iterating. If we already have ***nums[i]*** in the set, we found the duplicate.
--- 
### 3. **Sorting**
#### General idea: Sort the list in ascending order. Find duplicates using two pointers. If ***nums[i]*** is equal to ***nums[i + 1]***, we found the duplicate.
--- 
### 4. **Count**
#### General idea: Have array from 0 to n + 1 to keep track of the count of each ***nums[i]***. If we have count more than 1, we found the duplicate.
--- 
### 5. **Masking index**
#### General idea: We can mask visited index by making its value to negative value. If we found negative value in the index, we found the duplicate.
--- 
### 6. **Index Sort**
#### General idea: Because ***nums[i]*** are [1, n] inclusive, we can use index sort to find the duplicate. For each ***nums[i]***, we can check if it is in correct place by ***i + 1 == nums[i]***. If not, check if there is already duplicate value in the right place by ***nums[i] == nums[nums[i] - 1]***. Finally, we can swap the current value ***(nums[i])*** with the one that is in the right place ***(nums[nums[i] - 1])***.
--- 
### 7. **Fast Slow Pointer**
#### General idea: Map each ***nums[i]*** with ***i*** to create like linked list format. Then we can check if duplicate is in ***nums*** by detecting cycle.
* **Example:** nums = [1,3,4,2,2]. First start with 0, then we can navigate to next node by ***nums[nums[i]]***.
    * index = 0, 1, 2, 3, 4
    * nums = 1, 3, 4, 2, 2
    * final list format would be like this: 0 -> 1 -> 3 -> 2 -> 4 -> 2 -> 4 -> ... 
--- 
### 8. **Binary Search**
#### General idea: