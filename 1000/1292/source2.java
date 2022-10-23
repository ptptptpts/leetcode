class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rowMax = mat.length;
        int columnMax = mat[0].length;
        int[][] sumMatrix = new int[rowMax + 1][columnMax + 1];

        int sideLength = 0;
        for (int row = 0; row < rowMax; row++) {
            for (int column = 0; column < columnMax; column++) {
                int rowInPaddingMatrix = row + 1;
                int columnInPaddingMatrix = column + 1;

                sumMatrix[rowInPaddingMatrix][columnInPaddingMatrix] = mat[row][column]
                        + sumMatrix[rowInPaddingMatrix][columnInPaddingMatrix - 1]
                        + sumMatrix[rowInPaddingMatrix - 1][columnInPaddingMatrix]
                        - sumMatrix[rowInPaddingMatrix - 1][columnInPaddingMatrix - 1];

                int nextSideLength = sideLength + 1;
                if ((rowInPaddingMatrix >= nextSideLength) && (columnInPaddingMatrix >= nextSideLength)) {
                    int sumOfMatrix = sumMatrix[rowInPaddingMatrix][columnInPaddingMatrix]
                            - sumMatrix[rowInPaddingMatrix - nextSideLength][columnInPaddingMatrix]
                            - sumMatrix[rowInPaddingMatrix][columnInPaddingMatrix - nextSideLength]
                            + sumMatrix[rowInPaddingMatrix - nextSideLength][columnInPaddingMatrix - nextSideLength];
                    if (sumOfMatrix <= threshold) {
                        sideLength = nextSideLength;
                    }
                }
            }
        }

        return sideLength;
    }
}
