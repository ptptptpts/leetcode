import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int gridSize = m * n;
        k = k % gridSize;

        int[][] shiftedGrid = new int[m][n];
        for (int rowCursor = 0; rowCursor < m; rowCursor++) {
            for (int columnCursor = 0; columnCursor < n; columnCursor++) {
                int shiftedPosition = ((rowCursor * n) + columnCursor + k) % gridSize;
                int shiftedRow = shiftedPosition / n;
                int shiftedColumn = shiftedPosition % n;

                shiftedGrid[shiftedRow][shiftedColumn] = grid[rowCursor][columnCursor];
            }
        }
        return (List) Arrays.asList(shiftedGrid);
    }
}
