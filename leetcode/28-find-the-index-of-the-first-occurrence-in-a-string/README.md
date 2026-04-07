# 28. Find the Index of the First Occurrence in a String

#### Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

## Approach
### 1. **Two Pointers**
#### General idea: Having a pointer for each `haystack` and `needle`, we check `needle` is in `haystack`. At each index `i` of `haystack`, we can check if the character of `haystack` and `needle` are same. If they are same, we can move each pointer to next position and keep compare. Otherwise, we stop the comparison and move `i` to next position. At the end of the loop, we can check if index `j` of `needle` is equal to the size of `needle` n. If `j` is at `n`, it means we found `needle` from `haystack`, so we can return the start index by `i - needle.size()`. Finally, we can return `-1`, if we could not find the `needle`.
--- 
### 2. **KMP Algorithm**
#### General idea: to be updated
--- 