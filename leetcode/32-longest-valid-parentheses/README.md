# 32. Longest Valid Parentheses

#### Link: https://leetcode.com/problems/longest-valid-parentheses/description/

## Approach
### 1. **Stack**
#### General idea: Instead of pushing each character into `stack`, we push the **index** so we can easily calculate the length of current valid parentheses. To handle the case where entire `s` is valid parentheses, we initialize the `stack` with `-1`.
#### Then, as we loop through each **index** in `s`:
* If we encounter an open parenthesis `'('`, push `i` into the stack.
* If we encounter a close parenthesis `')'`:
    * If the stack is not empty, and top **index** is an open parenthesis, pop from the stack and calculate the length of valid parentheses by `i - stack.peek()` and update maximum length.
    * Otherwise, push `i` into the stack.
--- 