# 48. Rotate Image

#### Link: https://leetcode.com/problems/rotate-image/description/

## Approach
### 1. **Two-Phase In-Place Rotation**
#### General idea: Rotate the matrix 90° clockwise in-place by decomposing the rotation into two simpler operations: reverse rows (top-bottom swap) and transpose (main diagonal swap).
#### There are 2 phases:
1. **Reverse Rows:** Swap the top row and bottom row using two pointers (`top` and `bottom`). Increment `top` and decrement `bottom` until they meet. This vertically mirrors the matrix.
2. **Transpose:** Swap elements across the main diagonal by iterating with `row` from `0` to `n` and `col` from `row` to `n`. Starting `col` from `row` ensures each pair `(i, j)` and `(j, i)` is visited exactly once, preventing double-swapping.

#### Extended Design - Generalized Rotation API:
- **Enum:** Defined `CW_NINETY`, `CW_ONE_EIGHTY`, `CW_TWO_SEVENTY` with `CW_` prefix to make rotation direction explicit and unambiguous.
- **Building blocks:** Decomposed into reusable `swapRows()`, `swapColumns()`, and `transpose()` helper methods.
- **Rotation mappings:**
  - `CW_NINETY` → `swapRows` + `transpose`
  - `CW_ONE_EIGHTY` → `swapRows` + `swapColumns`
  - `CW_TWO_SEVENTY` → `swapColumns` + `transpose`
- **Centralized input validation** at the `rotate()` entry point handles `null` matrix, non-square matrix, and `n = 0` or `n = 1` cases.
- **Unsupported enum** values throw `UnsupportedOperationException` with a descriptive message.
---