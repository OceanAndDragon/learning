# 1537. Get the Maximum Score

#### Link: https://leetcode.com/problems/get-the-maximum-score/description/

## Approach
### 1. **Dynamic Programming + Memoization**
#### General idea: We can break this problem into smaller sub-problems. At each position, depending on which array we are currently on, we add the score along that path. If we encounter a value that exists in both arrays, we can either continue on the current path or switch to the other path at the same value, and we return the maximum score between two choices. We use lookup tables for each ***nums*** array, where the value is the key and the index is the value.
* Before applying dynamic programming, traverse each ***nums*** array to initialize the lookup tables.
* Each sub-problem is defined by the current index and which array we are on.
* Base case: return 0 if we reach the end of the current array.
* In each sub-problem, we add the current value from the array we are on.
* If the current value exists in the other array, we can choose to continue on the current path or switch to the other array at the same value, and take the maximum result without double counting the value.
--- 
### 2. **Dynamic Programming + Two Pointers**
#### General idea: By having two pointers, one for each ***nums*** array, we can keep track of the score of each path. We compare the values at both pointers, and add the smaller value to its corresponding score, then move that pointer forward. If both values are equal, we take the maximum of the two accumulated scores, add the current value, and update both scores to this value, then move both pointers forward. After one array is fully traversed, we continue adding the remaining values from the other array. Finally we return the maximum of the two scores.
--- 