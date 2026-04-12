# 238. Product of Array Except Self

#### Link: https://leetcode.com/problems/product-of-array-except-self/description/

## Approach
### 1. **Prefix and Suffix**
#### General idea: The idea is very simple here. We will compute the prefix and suffix of each element `nums[i]`, then get the result by `prefix[i] * suffix[i]`. Instead of maintaining both `prefix` and `suffix` arrays, we can have one output array and calculat both `prefix` and `suffix` on the fly.
* Each `prefix` would be `prefix *= nums[i]`, after assigning `prefix` to `result[i]`, where `result` is output array.
* Likewise, `suffix` would be `suffix *= nums[i]`, after updating `result[i] *= suffix`.
---