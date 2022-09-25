import java.util.Stack;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean isExist = false;

        int rowSize = board.length;;
        int columnSize = board[0].length;

        boolean[][] visitedBoard = new boolean[rowSize][columnSize];

        for (int rowCursor = 0; rowCursor < rowSize; rowCursor++) {
            for (int columnCursor = 0; columnCursor < columnSize; columnCursor++) {
                if (findSearch(board, word, visitedBoard, rowCursor, columnCursor, 0)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                break;
            }
        }

        return isExist;
    }

    private boolean findSearch(char[][] board, String word, boolean[][] visitedBoard, int rowCursor,
            int columnCursor, int wordCursor) {
        boolean isExist = false;

        if (board[rowCursor][columnCursor] == word.charAt(wordCursor)) {
            visitedBoard[rowCursor][columnCursor] = true;

            if (wordCursor == word.length() - 1) {
                isExist = true;
            } else {
                int rowSize = board.length;
                int columnSize = board[0].length;

                if ((rowCursor > 0)
                        && (!visitedBoard[rowCursor - 1][columnCursor])) {
                    if (findSearch(board, word, visitedBoard, rowCursor - 1, columnCursor,
                            wordCursor + 1)) {
                        isExist = true;
                    }
                }
                if ((!isExist) && (rowCursor < rowSize - 1)
                        && (!visitedBoard[rowCursor + 1][columnCursor])) {
                    if (findSearch(board, word, visitedBoard, rowCursor + 1, columnCursor,
                            wordCursor + 1)) {
                        isExist = true;
                    }
                }
                if ((!isExist) && (columnCursor > 0)
                        && (!visitedBoard[rowCursor][columnCursor - 1])) {
                    if (findSearch(board, word, visitedBoard, rowCursor, columnCursor - 1,
                            wordCursor + 1)) {
                        isExist = true;
                    }
                }
                if ((!isExist) && (columnCursor < columnSize - 1)
                        && (!visitedBoard[rowCursor][columnCursor + 1])) {
                    if (findSearch(board, word, visitedBoard, rowCursor, columnCursor + 1,
                            wordCursor + 1)) {
                        isExist = true;
                    }
                }
            }

            visitedBoard[rowCursor][columnCursor] = false;
        }

        return isExist;
    }
}
