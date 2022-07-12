class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int numberOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    visitAdjacentLand(grid, i, j);
                    numberOfIsland++;
                }
            }
        }

        return  numberOfIsland;
    }

    private void visitAdjacentLand(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        if ((i > 0) && (grid[i-1][j] == '1')) {
            visitAdjacentLand(grid, i-1, j);
        }
        if ((i < grid.length - 1) && (grid[i+1][j] == '1')) {
            visitAdjacentLand(grid, i+1, j);
        }
        if ((j > 0) && (grid[i][j-1] == '1')) {
            visitAdjacentLand(grid, i, j-1);
        }
        if ((j < grid[0].length - 1) && (grid[i][j+1] == '1')) {
            visitAdjacentLand(grid, i, j+1);
        }
    }
}
