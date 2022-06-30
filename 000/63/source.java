class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] paths = new int[m];
        if (obstacleGrid[0][0] == 0) {
            paths[0] = 1;
        } else {
            paths[0] = 0;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 0) {
                paths[i] = paths[i - 1];
            } else {
                paths[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                paths[0] = 0;
            }
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    paths[j] = paths[j - 1] + paths[j];
                } else {
                    paths[j] = 0;
                }
            }
        }
        return paths[m - 1];
    }
}
