public class code {

    public void rotate(int[][] matrix) {
        // swap top row and bottom row
        swapRows(matrix);
        // swap diagonally
        transpose(matrix);
    }

    /** Extended */
    public enum Degree {
        CW_NINETY, CW_ONE_EIGHTY, CW_TWO_SEVENTY;
    }

    public void rotate(int[][] matrix, Degree degree) {
        switch (degree) {
            case CW_NINETY -> {
                swapRows(matrix);
                transpose(matrix);
            }
            case CW_ONE_EIGHTY -> {
                swapRows(matrix);
                swapColumns(matrix);
            }
            case CW_TWO_SEVENTY -> {
                swapColumns(matrix);
                transpose(matrix);
            }
            default -> {
                throw new UnsupportedOperationException();
            }
        }
    }

    public void swapRows(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n - 1;
        // swap top row and bottom row
        while (top < bottom) {
            for (int c = 0; c < n; c++) {
                int temp = matrix[top][c];
                matrix[top][c] = matrix[bottom][c];
                matrix[bottom][c] = temp;
            }
            top++;
            bottom--;
        }
    }

    public void swapColumns(int[][] matrix) {
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        // swap left column and right column
        while (left < right) {
            for (int r = 0; r < n; r++) {
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;
            }
            left++;
            right--;
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        // swap diagonally
        int row = 0;
        while (row < n) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
            row++;
        }
    }
    
}
