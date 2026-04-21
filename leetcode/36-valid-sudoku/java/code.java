public class code {

    public boolean isValidSudoku(char[][] board) {
        // process row
        for (int r = 0; r < 9; r++) {
            char[] row = board[r];
            if (!validateLines(row)) {
                return false;
            }
        }
        // process column
        for (int c = 0; c < 9; c++) {
            char[] column = new char[9];
            for (int r = 0; r < 9; r++) {
                column[r] = board[r][c];
            }
            if (!validateLines(column)) {
                return false;
            }
        }
        // process 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] duplicate = new boolean[9];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int row = i * 3 + r;
                        int col = j * 3 + c;
                        if (!validate(duplicate, board[row][col])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean validateLines(char[] line) {
        boolean[] duplicate = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (!validate(duplicate, line[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(boolean[] duplicate, char curr) {
        if (curr != '.') {
            int num = (int) (curr - '1');
            if (duplicate[num]) {
                return false;
            } else {
                duplicate[num] = true;
            }
        }
        return true;
    }
    
}
