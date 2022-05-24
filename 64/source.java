class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] costGrid = new int[m];

        costGrid[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            costGrid[i] = costGrid[i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[] nextGrid = new int[m];
            nextGrid[0] = costGrid[0] + grid[i][0];

            for (int j = 1; j < m; j++) {
                nextGrid[j] = Math.min(nextGrid[j - 1], costGrid[j]) + grid[i][j];
            }

            costGrid = nextGrid;
        }

        return costGrid[m - 1];
    }
}
