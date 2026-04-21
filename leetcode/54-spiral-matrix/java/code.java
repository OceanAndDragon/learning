import java.util.ArrayList;
import java.util.List;

public class code {

    public List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix[0].length, n = matrix.length;
        int top = 0, left = 0, bottom = n - 1, right = m - 1;
        List<Integer> result = new ArrayList<>();
        while (bottom - top >= 0 && right - left >= 0) {
            int c = left, r = top;
            // process from topLeft to topRight
            while (c <= right) {
                result.add(matrix[r][c++]);
            }
            r++;
            c = right;
            // process from topRight to bottomRight
            while (r < bottom) {
                result.add(matrix[r++][c]);
            }
            // process from bottomRight to bottomLeft
            while (top < r && r <= bottom && c >= left) {
                result.add(matrix[r][c--]);
            }
            r--;
            c = left;
            // process from bottomLeft to topLeft
            while (top < r && left <= c && c < right) {
                result.add(matrix[r--][c]);
            }
            // update boundaries
            top++;
            left++;
            bottom--;
            right--;
        }
        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int columns = matrix[0].length, rows = matrix.length;
        int top = 0, left = 0, bottom = rows - 1, right = columns - 1;
        List<Integer> result = new ArrayList<>();
        while (bottom - top >= 0 && right - left >= 0) {
            // process top row
            if (top <= bottom) {
                for (int c = left; c <= right; c++) {
                    result.add(matrix[top][c]);
                }
            }
            // process from topRight to bottomRight
            if (left <= right) {
                for (int r = top + 1; r <= bottom; r++) {
                    result.add(matrix[r][right]);
                }
            }
            // process from bottomRight to bottomLeft
            if (top < bottom) {
                for (int c = right - 1; c >= left; c--) {
                    result.add(matrix[bottom][c]);
                }
            }
            // process from bottomLeft to topLeft
            if (left < right) {
                for (int r = bottom - 1; r > top; r--) {
                    result.add(matrix[r][left]);
                }
            }
            // update boundaries
            top++;
            left++;
            bottom--;
            right--;
        }
        return result;
    }
    
}
