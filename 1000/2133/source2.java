class Solution {
    public boolean checkValid(int[][] matrix) {
        boolean isValid = true;

        for (int cursor = 0; cursor < matrix.length; cursor++) {
            if (!isValidColumn(matrix, cursor) || !isValidRow(matrix, cursor)) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private boolean isValidColumn(int[][] matrix, int rowNumber) {
        return isValidRowColumn(matrix, rowNumber, false);
    }

    private boolean isValidRow(int[][] matrix, int columnNumber) {
        return isValidRowColumn(matrix, columnNumber, true);
    }

    private boolean isValidRowColumn(int[][] matrix, int position, boolean isRow) {
        boolean isValid = true;

        int matrixSize = matrix.length;
        for (int cursor = 0; cursor < matrixSize; cursor++) {
            int currentElement =
                    Math.abs(isRow ? matrix[cursor][position] : matrix[position][cursor]);
            int currnetPoint =
                    isRow ? matrix[currentElement - 1][position] : matrix[position][currentElement - 1];

            if ((0 < currentElement) && (currentElement <= matrixSize) && (currnetPoint > 0)) {
                if (isRow) {
                    matrix[currentElement - 1][position] *= -1;
                } else {
                    matrix[position][currentElement - 1] *= -1;
                }
            } else {
                isValid = false;
                break;
            }
        }

        for (int cursor = 0; cursor < matrixSize; cursor++) {
            if (isRow) {
                matrix[cursor][position] = Math.abs(matrix[cursor][position]);
            } else {
                matrix[position][cursor] = Math.abs(matrix[position][cursor]);
            }
        }

        return isValid;
    }
}
