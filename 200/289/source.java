class Solution {
    public void gameOfLife(int[][] board) {
        int[][] numberOfLiveCellBoard = findNumberOfLiveNeighbors(board);
        updateNextStep(board, numberOfLiveCellBoard);
    }

    private int[][] findNumberOfLiveNeighbors(int[][] board) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;
        int[][] numberOfLiveColumnNeighbors = new int[numberOfRows][numberOfColumns];
        int[][] numberOfLiveNeighbors = new int[numberOfRows][numberOfColumns];

        for (int rowCursor = 0; rowCursor < numberOfRows; rowCursor++) {
            if (numberOfColumns > 1) {
                numberOfLiveColumnNeighbors[rowCursor][0] = board[rowCursor][0] + board[rowCursor][1];

                for (int columnCursor = 1; columnCursor < numberOfColumns - 1; columnCursor++) {
                    numberOfLiveColumnNeighbors[rowCursor][columnCursor] = board[rowCursor][columnCursor - 1]
                            + board[rowCursor][columnCursor] + board[rowCursor][columnCursor + 1];
                }

                numberOfLiveColumnNeighbors[rowCursor][numberOfColumns - 1] = board[rowCursor][numberOfColumns - 2]
                        + board[rowCursor][numberOfColumns - 1];
            } else {
                numberOfLiveColumnNeighbors[rowCursor][0] = board[rowCursor][0];
            }
        }

        if (numberOfRows > 1) {
            for (int columnCursor = 0; columnCursor < numberOfColumns; columnCursor++) {
                numberOfLiveNeighbors[0][columnCursor] = numberOfLiveColumnNeighbors[0][columnCursor]
                        + numberOfLiveColumnNeighbors[1][columnCursor] - board[0][columnCursor];
            }
            for (int rowCursor = 1; rowCursor < numberOfRows - 1; rowCursor++) {
                for (int columnCursor = 0; columnCursor < numberOfColumns; columnCursor++) {
                    numberOfLiveNeighbors[rowCursor][columnCursor] =
                            numberOfLiveColumnNeighbors[rowCursor - 1][columnCursor]
                                    + numberOfLiveColumnNeighbors[rowCursor][columnCursor]
                                    + numberOfLiveColumnNeighbors[rowCursor + 1][columnCursor]
                                    - board[rowCursor][columnCursor];
                }
            }
            for (int columnCursor = 0; columnCursor < numberOfColumns; columnCursor++) {
                numberOfLiveNeighbors[numberOfRows - 1][columnCursor] =
                        numberOfLiveColumnNeighbors[numberOfRows - 2][columnCursor]
                                + numberOfLiveColumnNeighbors[numberOfRows - 1][columnCursor]
                                - board[numberOfRows - 1][columnCursor];
            }
        }

        return numberOfLiveNeighbors;
    }

    private void updateNextStep(int[][] board, int[][] numberOfLiveNeighbors) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;

        for (int rowCursor = 0; rowCursor < numberOfRows; rowCursor++) {
            for (int columnCursor = 0; columnCursor < numberOfColumns; columnCursor++) {
                // Live cell: live neighbors < 2 -> die
                // Live cell: 2 <= live neighbors <= 3 -> live
                // Live cell: 3 < live neighbors -> die
                // Die cell: live neightbors == 3 -> live
                int numberOfLiveNeighbor = numberOfLiveNeighbors[rowCursor][columnCursor];

                if (board[rowCursor][columnCursor] == 1) {
                    if ((numberOfLiveNeighbor < 2) || (numberOfLiveNeighbor > 3)) {
                        board[rowCursor][columnCursor] = 0;
                    }
                } else {
                    if (numberOfLiveNeighbor == 3) {
                        board[rowCursor][columnCursor] = 1;
                    }
                }
            }
        }
    }
}
