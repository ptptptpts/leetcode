class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateSudokuRow(board)
                && validateSudokuColumn(board)
                && validateSudokuSubBox(board);
    }

    private boolean validateSudokuRow(char[][] board) {
        boolean isValid = true;

        for (int row = 0; row < 9; row++) {
            boolean[] hasDigits = new boolean[10];

            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {
                    int cellDigit = board[row][column] - '0';

                    if (!hasDigits[cellDigit]) {
                        hasDigits[cellDigit] = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                break;
            }
        }

        return isValid;
    }

    private boolean validateSudokuColumn(char[][] board) {
        boolean isValid = true;

        for (int column = 0; column < 9; column++) {
            boolean[] hasDigits = new boolean[10];

            for (int row = 0; row < 9; row++) {
                if (board[row][column] != '.') {
                    int cellDigit = board[row][column] - '0';

                    if (!hasDigits[cellDigit]) {
                        hasDigits[cellDigit] = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                break;
            }
        }

        return isValid;
    }

    private boolean validateSudokuSubBox(char[][] board) {
        boolean isValid = true;

        for (int boxNumber = 0; boxNumber < 9; boxNumber++) {
            boolean[] hasDigits = new boolean[10];

            int baseRow = (boxNumber / 3) * 3;
            int baseColumn = (boxNumber % 3) * 3;

            for (int posInBox = 0; posInBox < 9; posInBox++) {
                int row = baseRow + (posInBox / 3);
                int column = baseColumn + (posInBox % 3);

                if (board[row][column] != '.') {
                    int cellDigit = board[row][column] - '0';

                    if (!hasDigits[cellDigit]) {
                        hasDigits[cellDigit] = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                break;
            }
        }

        return isValid;
    }
}
