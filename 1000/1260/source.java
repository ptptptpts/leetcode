import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int gridSize = m * n;

        k = k % gridSize;

        List<List<Integer>> shiftedGrid = new ArrayList<>(m);
        List<Integer> currentShiftedRow = new ArrayList<>(n);

        for (int cursor = gridSize - k; cursor < gridSize; cursor++) {
            currentShiftedRow = getIntegers(grid, n, shiftedGrid, currentShiftedRow, cursor);
        }
        for (int cursor = 0; cursor < gridSize - k; cursor++) {
            currentShiftedRow = getIntegers(grid, n, shiftedGrid, currentShiftedRow, cursor);
        }

        return shiftedGrid;
    }

    private List<Integer> getIntegers(int[][] grid, int n, List<List<Integer>> shiftedGrid,
            List<Integer> currentShiftedRow, int cursor) {
        int cursorM = cursor / n;
        int cursorN = cursor % n;
        currentShiftedRow.add(grid[cursorM][cursorN]);

        if (currentShiftedRow.size() == n) {
            shiftedGrid.add(currentShiftedRow);
            currentShiftedRow = new ArrayList<>(n);
        }
        return currentShiftedRow;
    }
}
