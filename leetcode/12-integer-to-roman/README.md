# 12. Integer to Roman

#### Link: https://leetcode.com/problems/integer-to-roman/description/

## Approach
### 1. **Greedy Table Lookup**
#### General idea: The key idea is to greedily match the largest possible Roman numeral value at each step using a prebuilt lookup table that includes both standard and subtractive forms. By iterating from largest to smallest, we can construct the Roman numeral without any special casing at runtime.
#### The lookup table is consisted of two arrays, `numbers` and `symbols`:
- 7 standard forms: `1000→M`, `500→D`, `100→C`, `50→L`, `10→X`, `5→V`, `1→I`
- 6 subtractive forms: `900→CM`, `400→CD`, `90→XC`, `40→XL`, `9→IX`, `4→IV`
#### There are 2 phases:
1. **Table Construction:** Build the `numbers` and `symbols` with all 13 value-to-symbol mappings, including precomputed subtractive forms. This eliminates the need to detect 4/9 cases at runtime.
2. **Greedy Loop:** Iterate through each entry. For each entry:
   - If `num <= 0`, break early.
   - While `num >= numbers[i]`, append the `symbols[i]` to the `StringBuilder` and subtract `numbers[i]` from `num`.
---