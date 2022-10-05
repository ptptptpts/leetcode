class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int numberOfIsland = 0;
        // Find island in each cell
        for (int posM = 0; posM < m; posM++) {
            for (int posN = 0; posN < n; posN++) {
                if (grid[posM][posN] == '1') {
                    // Update all the lands in island as water
                    fillIslandByWater(grid, posM, posN);
                    numberOfIsland++;
                }
            }
        }

        // Return a number of island
        return numberOfIsland;
    }

    private void fillIslandByWater(char[][] grid, int posM, int posN) {
        grid[posM][posN] = '0';

        if ((posM > 0) && (grid[posM - 1][posN] == '1')) {
            fillIslandByWater(grid, posM - 1, posN);
        }
        if ((posN > 0) && (grid[posM][posN - 1] == '1')) {
            fillIslandByWater(grid, posM, posN - 1);
        }
        if ((posM < grid.length - 1) && (grid[posM + 1][posN] == '1')) {
            fillIslandByWater(grid, posM + 1, posN);
        }
        if ((posN < grid[0].length - 1) && (grid[posM][posN + 1] == '1')) {
            fillIslandByWater(grid, posM, posN + 1);
        }
    }
}
