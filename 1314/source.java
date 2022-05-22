class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] sumMatrix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            sumMatrix[i][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            sumMatrix[0][m] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix[i + 1][j + 1] =
                        mat[i][j] + sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j];
            }
        }

        int[][] blockSumMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int upper = ((i - k) >= 0) ? i - k : 0;
            int lower = ((i + k) < n) ? i + k : n - 1;
            for (int j = 0; j < m; j++) {
                int left = ((j - k) >= 0) ? j - k : 0;
                int right = ((j + k) < m) ? j + k : m - 1;
                blockSumMatrix[i][j] = sumMatrix[lower + 1][right + 1] - sumMatrix[lower + 1][left]
                        - sumMatrix[upper][right + 1] + sumMatrix[upper][left];
            }
        }
        return blockSumMatrix;
    }
}
