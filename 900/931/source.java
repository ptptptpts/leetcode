class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int matrixSize = matrix.length;

        for (int row = 1; row < matrixSize; row++) {
            matrix[row][0] = Math.min(matrix[row - 1][0], matrix[row - 1][1]) + matrix[row][0];
            for (int column = 1; column < matrixSize - 1; column++) {
                matrix[row][column] =
                        Math.min(Math.min(matrix[row - 1][column - 1], matrix[row - 1][column]),
                                matrix[row - 1][column + 1]) + matrix[row][column];
            }
            matrix[row][matrixSize - 1] =
                    Math.min(matrix[row - 1][matrixSize - 2], matrix[row - 1][matrixSize - 1])
                            + matrix[row][matrixSize - 1];
        }

        int ret = matrix[matrixSize - 1][0];
        for (int i = 1; i < matrixSize; i++) {
            if (ret > matrix[matrixSize - 1][i]) {
                ret = matrix[matrixSize - 1][i];
            }
        }
        return ret;
    }
}
