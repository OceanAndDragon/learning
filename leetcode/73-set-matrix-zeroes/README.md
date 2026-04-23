# 73. Set Matrix Zeroes

#### Link: https://leetcode.com/problems/set-matrix-zeroes/description/

## Approach
### 1. **Three-Phase In-Place Zero Propagation**
#### General idea: Use the first row and first column of the matrix itself as marker space to track which rows and columns need to be zeroed, avoiding extra space. Two boolean flags handle the edge case where the first row or column themselves contain zeros.
#### There are 3 phases:
1. **Pre-scan First Row and Column:** Before using them as markers, check if the first row or first column originally contain any zeros. Store results in `firstRowZero` and `firstColZero` boolean flags. This is critical because we will overwrite these cells later as markers.
2. **Mark and Update:** Iterate from `(1,1)`. For any cell `matrix[r][c] == 0`, mark `matrix[r][0] = 0` and `matrix[0][c] = 0`. Then do a second pass from `(1,1)` — if `matrix[r][0] == 0` or `matrix[0][c] == 0`, zero out `matrix[r][c]`. Starting from `(1,1)` ensures markers in the first row and column are never corrupted during traversal.
3. **Handle First Row and Column:** Using the pre-scanned flags, zero out the entire first row if `firstRowZero` is true, and zero out the entire first column if `firstColZero` is true. These must be handled last to avoid corrupting the markers before the main update is complete.

#### Key Correctness Insight:
- The brute force approach of zeroing rows and columns on the fly introduces **corruption** — newly zeroed cells are mistaken for original zeros, causing unintended propagation.
- Using the first row and column as markers works because they are **never processed as source cells** during the marking phase (we start from `(1,1)`), and their original zero state is **preserved separately** via boolean flags.
---