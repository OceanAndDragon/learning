# 274. H-Index

#### Link: https://leetcode.com/problems/h-index/description/

## Approach
### 1. **Sorting**
#### General idea: Sort `citations` in descending order. At each index `i`, there are exactly `i + 1` papers with at least `citations[i]` citations. Therefore, `i + 1` is a valid h-index if `citations[i] >= i + 1`. We update `h = i + 1` as long as this condition holds, and break early once it fails since the array is sorted and the condition will never be true again.
---
### 2. **Counting Sort**
#### General idea: Since the h-index can never exceed `n` (total number of papers), we initialize a `buckets` array of size `n + 1`. We populate it by counting citations, capping any citation greater than `n` at index `n`.
#### Next, we traverse `buckets` in reverse order, accumulating a running `count` of papers. At each index `i`, `count` represents the number of papers with at least `i` citations. The largest `i` where `count >= i` is our h-index.
---