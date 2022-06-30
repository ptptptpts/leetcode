import java.util.Stack;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<int[]> currentDay = new Stack<>();
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    currentDay.add(new int[]{i, j});
                }
            }
        }

        if ((currentDay.isEmpty()) && (freshOranges > 0)) {
            return -1;
        }

        int currentMinutes = 0;
        while (!currentDay.isEmpty()) {
            if (freshOranges == 0) {
                break;
            }
            currentMinutes++;

            Stack<int[]> nextDay = new Stack<>();
            for (int[] pos : currentDay) {
                freshOranges = rotAdjecentOranges(grid, freshOranges, m, n, nextDay, pos);
            }
            currentDay = nextDay;
        }
        if (freshOranges == 0) {
            return currentMinutes;
        } else {
            return -1;
        }
    }

    private int rotAdjecentOranges(int[][] grid, int freshOranges, int m, int n,
            Stack<int[]> nextDay, int[] pos) {
        int i = pos[0];
        int j = pos[1];

        if (i > 0) {
            freshOranges = rotFreshOrange(grid, freshOranges, nextDay, i-1, j);
        }
        if (i < m - 1) {
            freshOranges = rotFreshOrange(grid, freshOranges, nextDay, i+1, j);
        }
        if (j > 0) {
            freshOranges = rotFreshOrange(grid, freshOranges, nextDay, i, j-1);
        }
        if (j < n - 1) {
            freshOranges = rotFreshOrange(grid, freshOranges, nextDay, i, j + 1);
        }
        return freshOranges;
    }

    private int rotFreshOrange(int[][] grid, int freshOranges, Stack<int[]> nextDay, int i,
            int j) {
        if (grid[i][j] == 1) {
            nextDay.add(new int[]{i, j});
            grid[i][j] = 2;
            freshOranges--;
        }
        return freshOranges;
    }
}