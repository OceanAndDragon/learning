# 169. Majority Element

#### Link: https://leetcode.com/problems/majority-element/description/

## Approach
### 1. **Boyer-Moore Voting Algorithm**
#### General idea: Boyer-Moore Voting Algorithm works by maintaining a `candidate` and a `count`. We loop through the `nums` array and compare each `num` with the current `candidate`. First, every time when `count` is equal to 0, we assign `num` to `candidate` then increment `count`. If `candidate` is equal to `num`, we increment the `count`. If not, we decrement the `count`.
#### This algorithm will work since every time a non-majority element cancels a majority element, which means both will be discarded. Since a majority element will appear more than `n/2` times, it will be never cancelled out by a non-majority element.
--- 