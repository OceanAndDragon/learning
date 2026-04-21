# 54. Spiral Matrix

#### Link: https://leetcode.com/problems/spiral-matrix/description/

## Approach
### 1. **Boundary Shrinking Pattern**
#### General idea: Same boundary shrinking concept, but traversal used a live `r`/`c` pointer carried across all 4 sides within one loop iteration, with compound conditions guarding each side's inner while loop.
#### There are 4 phases per round:
1. **Top-left to Top-right:** Traverse from `c = left` to `c = right` along `r = top`. Increment `r` and reset `c = right` after.
2. **Top-right to Bottom-right:** Traverse from current `r` while `r < bottom` along `c = right`. No explicit start guard.
3. **Bottom-right to Bottom-left:** Traverse while `top < r && r <= bottom && c >= left`. Compound condition needed because `r`/`c` state carried over from previous side.
4. **Bottom-left to Top-left:** Traverse while `top < r && left <= c && c < right`. Again compound condition to compensate for shared pointer state.
#### ❌ What was missed in Approach 1:
- **Shared mutable pointer across sides:** Carrying `r` and `c` across all 4 sides created hidden dependencies. Each side's starting position depended on where the previous side left off, making it hard to reason about correctness independently.
- **Compound loop guard conditions:** Because of the shared pointer, guards like `top < r && r <= bottom && c >= left` were needed to prevent over-traversal. These are hard to verify at a glance and fragile under edge cases.
- **Corner double-counting risk:** Without clear per-side start/end boundaries, it was easy to accidentally revisit corners, requiring extra care embedded in the compound conditions rather than being structurally prevented.
- **Variable naming:** `m` was assigned to `matrix[0].length` (columns) which inverts the conventional `m x n` = rows x columns meaning.
---
### 2. **Boundary Shrinking Pattern (Refined)**
#### General idea: Each side is treated as a fully independent traversal with its own `for` loop and a dedicated `if` guard checked before entering. The `r`/`c` pointer is no longer shared across sides — each side computes its own range explicitly from the current boundary values.
#### There are 4 phases per round:
1. **Top row (left → right):** Guard: `if (top <= bottom)`. Traverse `c` from `left` to `right` along `matrix[top][c]`.
2. **Right column (top+1 → bottom):** Guard: `if (left <= right)`. Traverse `r` from `top+1` to `bottom` along `matrix[r][right]`. Starting at `top+1` avoids double-counting the top-right corner.
3. **Bottom row (right-1 → left):** Guard: `if (top < bottom)`. Traverse `c` from `right-1` to `left` along `matrix[bottom][c]`. Starting at `right-1` avoids double-counting the bottom-right corner. Guard uses strict `<` to skip when only one row remains.
4. **Left column (bottom-1 → top+1):** Guard: `if (left < right)`. Traverse `r` from `bottom-1` down to `top+1` along `matrix[r][left]`. Avoids double-counting both the bottom-left and top-left corners. Guard uses strict `<` to skip when only one column remains.
5. **Shrink boundaries:** `top++`, `bottom--`, `left++`, `right--`.
#### ✅ What got better in Approach 2:
- **Independent per-side traversal:** Each side derives its range purely from current boundary values. No shared pointer state, no hidden dependencies between sides.
- **Simple, readable guard conditions:** A single `if` per side replaces compound while conditions. Any engineer can verify correctness at a glance.
- **Structural corner safety:** Starting each side one step past the previous side's endpoint (e.g., `top+1`, `right-1`) prevents double-counting by construction, not by condition.
- **Edge cases absorbed naturally:** Single row, single column, and single cell cases are all handled by the per-side guards without any special-casing or visited array.
- **Cleaner variable naming:** `rows` and `columns` replace ambiguous `m`/`n`, consistent with conventional matrix notation.
---