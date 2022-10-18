class Solution {
    //    0 <= k < n-1 (example: 0 <= k < 3)
    //    1 <= k < n-2 (example: 1 <= k < 2)
    //    ..
    //    a <= k < n - a - 1
    //    until the loop has at least one element
    public void rotate(int[][] matrix) {
        int matrixSize = matrix.length;

        for (int rotateRow = 0; rotateRow < matrixSize; rotateRow++) {
            for (int rotateColumn = rotateRow; rotateColumn < (matrixSize - rotateRow - 1); rotateColumn++) {
                int temp = matrix[rotateRow][rotateColumn];
                matrix[rotateRow][rotateColumn] =
                        matrix[matrixSize - rotateColumn - 1][rotateRow];
                matrix[matrixSize - rotateColumn - 1][rotateRow] =
                        matrix[matrixSize - rotateRow - 1][matrixSize - rotateColumn - 1];
                matrix[matrixSize - rotateRow - 1][matrixSize - rotateColumn - 1] =
                        matrix[rotateColumn][matrixSize - rotateRow - 1];
                matrix[rotateColumn][matrixSize - rotateRow - 1] = temp;
            }
        }
    }
}
