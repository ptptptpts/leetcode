class NumMatrix {

    int[][] mSumMatrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        mSumMatrix = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            mSumMatrix[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            mSumMatrix[0][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mSumMatrix[i + 1][j + 1] = matrix[i][j] + mSumMatrix[i][j + 1]
                        + mSumMatrix[i + 1][j] - mSumMatrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mSumMatrix[row2 + 1][col2 + 1] - mSumMatrix[row1][col2 + 1]
                - mSumMatrix[row2 + 1][col1] + mSumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
