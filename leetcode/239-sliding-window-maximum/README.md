# 239. Sliding Window Maximum

#### Link: https://leetcode.com/problems/sliding-window-maximum/description/

## Approach
### 1. **Monotonic Queue**
#### General idea: Using monotonic queue we can only store the maximum value in ***k*** window. On every ***i***, we can check if the first element in queue is still in range of ***k*** window. If it is out of range, we can remove. Likewise, we can check if the last element in queue is larger than current element because we only care about the maximum value. We can remove if the last element in queue is less than current element.
---