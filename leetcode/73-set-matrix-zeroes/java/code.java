public class code {

    public void setZeroes(int[][] matrix) {
        boolean firstColZero = false;
        boolean firstRowZero = false;
        // check if first columns have zero
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // check if first rows have zero
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // mark row or column as zero as we traverse each cell from (1,1)
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        // update each row to zero by looking at the marker
        for (int r = 1; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < matrix[r].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        // update each column to zero by looking at the marker
        for (int c = 1; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        // handle the first rows and first columns
        if (firstRowZero) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
        if (firstColZero) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
    
}
