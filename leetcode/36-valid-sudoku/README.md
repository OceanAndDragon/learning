# 36. Valid Sudoku

#### Link: https://leetcode.com/problems/valid-sudoku/description/

## Approach
### 1. **Three-Pass Validation with Extracted Helpers**
#### General idea: Validate the 9×9 Sudoku board in three separate passes — rows, columns, and 3×3 boxes — by extracting each unit as a `char[]` and passing it through a shared `validateLines` helper, using a boolean duplicate array of size 9 with char-to-index mapping via `board[r][c] - '1'`.
#### There are 3 phases:
1. **Row Validation:** Iterate over each of the 9 rows. Each row is already a `char[]` in the 2D array, so pass `board[r]` directly to `validateLines`. Return `false` immediately if any row contains a duplicate digit.
2. **Column Validation:** Iterate over each of the 9 columns. Since columns are not contiguous in memory, explicitly construct a `char[]` of length 9 by collecting `board[r][c]` for each row `r` at the fixed column index `c`. Pass the constructed array to `validateLines`. Return `false` immediately if any column contains a duplicate digit.
3. **3×3 Box Validation:** Use two outer loops `i` and `j` from `0` to `2` to identify each of the 9 boxes. Use `i * 3` and `j * 3` as the top-left corner anchors. Flatten each box into a `char[]` of length 9 using inner loops `r` and `c` from `0` to `2`, accessing `board[i*3+r][j*3+c]`. Pass the constructed array to `validateLines`. Return `false` immediately if any box contains a duplicate digit
---