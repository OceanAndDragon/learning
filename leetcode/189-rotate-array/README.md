# 189. Rotate Array

#### Link: https://leetcode.com/problems/rotate-array/description/

## Approach
### 1. **Cycle Replacements**
#### General idea: First, we normalize `k` by performing `k %= n`, and return immediately if `k == 0`. Use a `start` pointer to track the beginning of each cycle, and two variables `curr` and `next` to traverse and shift each element to its correct position `(curr + k) % n`. Repeat this process `n` times to ensure every element is moved to correct positions.
#### In each step, we perform:
1. Compute `next = (curr + k) % n` and move the current value to the computed index.
2. If a cycle detected, where `next == start`, increment `start` and begin a new cycle from there.
--- 