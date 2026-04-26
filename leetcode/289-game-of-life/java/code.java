import java.util.HashSet;
import java.util.Set;

public class code {

    private static final int[][] DIRECTIONS = new int[][] {{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1},{1,-1},{-1,1}};

    public record Cell(int r, int c) {} 

    public Set<Cell> gameOfLife(Set<int[]> liveCells) {
        Set<Cell> nextLiveCells = new HashSet<>();
        // collect dead cells
        Set<Cell> deadNeighbors = new HashSet<>();
        // process live cell
        for (int[] liveCell : liveCells) {
            int r = liveCell[0], c = liveCell[1];
            int counts = countLiveCells(deadNeighbors, r, c);
            if (counts == 2 || counts == 3) {
                nextLiveCells.add(new Cell(r, c));
            }
        }
        for (Cell deadNeighbor : deadNeighbors) {
            int r = deadNeighbor.r, c = deadNeighbor.c;
            int counts = countLiveNeighbors(r, c);
            if (counts == 3) {
                nextLiveCells.add(new Cell(r, c));
            }
        }
        return nextLiveCells;
    }

    public int countLiveCells(Set<Cell> deadNeighbors, int r, int c) {
        int counts = 0;
        for (int[] dir : DIRECTIONS) {
            int x = r + dir[0];
            int y = c + dir[1];
            Cell currentCell = new Cell(x, y);
            // check LIVE and DIED cell
            if (isLiveCell(x, y)) {
                counts++;
            } else if (!deadNeighbors.contains(currentCell)) {
                deadNeighbors.add(new Cell(x, y));
            }
        }
        return counts;
    }

    public int countLiveNeighbors(int r, int c) {
        int counts = 0;
        for (int[] dir : DIRECTIONS) {
            int x = r + dir[0];
            int y = c + dir[1];
            Cell currentCell = new Cell(x, y);
            // check LIVE and DIED cell
            if (isLiveCell(x, y)) {
                counts++;
            }
        }
        return counts;
    }

    public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int cell = board[r][c];
                int counts = countLiveCells(board, r, c);
                // DEAD cell
                if (cell == 0 && counts == 3) {
                    // update to WENT LIVE
                    board[r][c] = 2;
                } else if (cell == 1 && (counts < 2 || counts > 3)) {
                    // update to DIED
                    board[r][c] = -1;
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int cell = board[r][c];
                // WENT LIVE cell
                if (cell == 2) {
                    // update to LIVE
                    board[r][c] = 1;
                }
                // DIED cell
                else if (cell == -1) {
                    // update to DEAD
                    board[r][c] = 0;
                }
            }
        }
    }

    public int countLiveCells(int[][] board, int r, int c) {
        int counts = 0;
        for (int[] dir : DIRECTIONS) {
            int x = r + dir[0];
            int y = c + dir[1];
            // check LIVE and DIED cell
            if (isLiveCell(board, x, y)) {
                counts++;
            }
        }
        return counts;
    }

    public boolean isLiveCell(int[][] board, int x, int y) {
        return 0 <= Math.min(x, y) && x < board.length && y < board[x].length && (board[x][y] == 1 || board[x][y] == -1);
    }
    
}
