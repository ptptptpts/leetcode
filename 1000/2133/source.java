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
        boolean[] isExist = new boolean[matrixSize + 1];
        for (int cursor = 0; cursor < matrixSize; cursor++) {
            int currentElement = isRow ? matrix[cursor][position] : matrix[position][cursor];
            if ((0 < currentElement) && (currentElement <= matrixSize) && !isExist[currentElement]) {
                isExist[currentElement] = true;
            } else {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
