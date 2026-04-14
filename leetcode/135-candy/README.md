# 135. Candy

#### Link: https://leetcode.com/problems/candy/description/

## Approach
### 1. **Greedy**
#### General idea: The key idea here is to keep track of the **ascending and descending patterns (peak and valley patterns)** and increment the total counts based on these patterns. At each time we encounter where these patterns break, such as the next `rating` is same as the previous `rating`, we can refresh our tracking of the patterns and start from the base.
#### We will have initial value as the length of `ratings` because each child should have at least 1 candy. So the minimum valid total candies would be same as the length of `ratings`.
#### There are 3 cases we need to handle:
1. When we encounter the flat pattern, where `ratings[i - 1] == ratings[i]`, we reset both `asc` and `desc` to 0.
2. When we encounter the ascending pattern, where `ratings[i - 1] < ratings[i]`, we reset `desc` to 0, increment `asc`, and increment total `candies` by `asc`. If we reach to the end with this ascending pattern, we can just return `candies`.
3. When we encounter the descending pattern, where `ratings[i - 1] > ratings[i]`,increment `desc`, and increment total `candies` by `desc`. If we reach to the end, we will subtract `min(asc, desc)` from `candies` to avoid double counting the peak child, who was already counted once during the ascending phase and once during the descending phase.

## Example: [3,4,3,2,1,2,3,3,4,5,5,6,5,4,3,2,1]

**Initial:** `candies = 17` (length of ratings), `asc = 0`, `desc = 0`

| i | ratings[i-1] | ratings[i] | pattern | asc | desc | candies | action |
|---|---|---|---|---|---|---|---|
| 1 | 3 | 4 | ascending | 1 | 0 | 17+1=18 | reset desc, asc++ |
| 2 | 4 | 3 | descending | 1 | 1 | 18+1=19 | desc++ |
| 3 | 3 | 2 | descending | 1 | 2 | 19+2=21 | desc++ |
| 4 | 2 | 1 | descending | 1 | 3 | 21+3-1=23 | desc++, -min(asc, desc) |
| 5 | 1 | 2 | ascending | 1 | 0 | 23+1=24 | reset desc, asc++ |
| 6 | 2 | 3 | ascending | 2 | 0 | 24+2=26 | asc++ |
| 7 | 3 | 3 | flat | 0 | 0 | 26 | reset asc, desc |
| 8 | 3 | 4 | ascending | 1 | 0 | 26+1=27 | reset desc, asc++ |
| 9 | 4 | 5 | ascending | 2 | 0 | 27+2=29 | asc++ |
| 10 | 5 | 5 | flat | 0 | 0 | 29 | reset asc, desc |
| 11 | 5 | 6 | ascending | 1 | 0 | 29+1=30 | reset desc, asc++ |
| 12 | 6 | 5 | descending | 1 | 1 | 30+1=31 | desc++ |
| 13 | 5 | 4 | descending | 1 | 2 | 31+2=33 | desc++ |
| 14 | 4 | 3 | descending | 1 | 3 | 33+3=36 | desc++ |
| 15 | 3 | 2 | descending | 1 | 4 | 36+4=10 | desc++ |
| 16 | 2 | 1 | descending | 1 | 5 | 40+5-1=44 | desc++, -min(asc, desc) |

#### **Final candies: 44**
---