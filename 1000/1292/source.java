class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rowMax = mat.length;
        int columnMax = mat[0].length;

        for (int column = 1; column < columnMax; column++) {
            mat[0][column] += mat[0][column - 1];
        }
        for (int row = 1; row < rowMax; row++) {
            mat[row][0] += mat[row - 1][0];
            for (int column = 1; column < columnMax; column++) {
                mat[row][column] += mat[row][column - 1] + mat[row - 1][column] - mat[row - 1][column - 1];
            }
        }

        int sideLength = 0;
        for (int row = 0; row < rowMax; row++) {
            for (int column = 0; column < columnMax; column++) {
                int nextSideLength = sideLength + 1;
                if ((row >= (nextSideLength - 1)) && (column >= (nextSideLength - 1))) {
                    int sumOfMatrix = findSumOfMatrix(mat, row, column, nextSideLength);
                    if (sumOfMatrix <= threshold) {
                        sideLength = nextSideLength;
                    }
                }
            }
        }
        return sideLength;
    }

    private int findSumOfMatrix(int[][] sumMatrix, int endRow, int endColumn, int sideLength) {
        if (((endRow - sideLength) > -1) && ((endColumn - sideLength) > -1)) {
            return sumMatrix[endRow][endColumn]
                    - sumMatrix[endRow - sideLength][endColumn]
                    - sumMatrix[endRow][endColumn - sideLength]
                    + sumMatrix[endRow - sideLength][endColumn - sideLength];
        } else {
            if (((endRow - sideLength) == -1) && ((endColumn - sideLength) == -1)) {
                return sumMatrix[endRow][endColumn];
            } else if ((endRow - sideLength) == -1) {
                return sumMatrix[endRow][endColumn]
                        - sumMatrix[endRow][endColumn - sideLength];
            } else {
                return sumMatrix[endRow][endColumn]
                        - sumMatrix[endRow - sideLength][endColumn];
            }
        }
    }
}
