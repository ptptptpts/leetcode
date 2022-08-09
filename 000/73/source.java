class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean hasFirstRowZero = false;
        boolean hasFirstColumnZero = false;

        for (int cursor = 0; cursor < n; cursor++) {
            if (matrix[0][cursor] == 0) {
                hasFirstColumnZero = true;
                break;
            }
        }
        for (int cursor = 0; cursor < m; cursor++) {
            if (matrix[cursor][0] == 0) {
                hasFirstRowZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int cursor = 1; cursor < n; cursor++) {
            if (matrix[0][cursor] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][cursor] = 0;
                }
            }
        }
        for (int cursor = 1; cursor < m; cursor++) {
            if (matrix[cursor][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[cursor][j] = 0;
                }
            }
        }
        if (hasFirstColumnZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (hasFirstRowZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
