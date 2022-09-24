import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public List<Integer> spiralOrder(int[][] matrix) {
        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        int matrixSize = maxRow * maxColumn;
        List<Integer> result = new ArrayList<>(matrixSize);

        int traverseWay = RIGHT;
        int[] boundary = new int[] {0, maxColumn - 1, 0, maxRow - 1};
        int resultCursor = 0;
        int rowCursor = 0;
        int columnCursor = 0;
        while (resultCursor < matrixSize - 1) {
            switch (traverseWay) {
                case LEFT:
                    while (columnCursor > boundary[LEFT]) {
                        result.add(matrix[rowCursor][columnCursor]);
                        columnCursor--;
                        resultCursor++;
                    }
                    boundary[DOWN]--;
                    traverseWay = UP;
                    break;
                case RIGHT:
                    while (columnCursor < boundary[RIGHT]) {
                        result.add(matrix[rowCursor][columnCursor]);
                        columnCursor++;
                        resultCursor++;
                    }
                    boundary[UP]++;
                    traverseWay = DOWN;
                    break;
                case UP:
                    while (rowCursor > boundary[UP]) {
                        result.add(matrix[rowCursor][columnCursor]);
                        rowCursor--;
                        resultCursor++;
                    }
                    boundary[LEFT]++;
                    traverseWay = RIGHT;
                    break;
                case DOWN:
                    while (rowCursor < boundary[DOWN]) {
                        result.add(matrix[rowCursor][columnCursor]);
                        rowCursor++;
                        resultCursor++;
                    }
                    boundary[RIGHT]--;
                    traverseWay = LEFT;
                    break;
            }
        }
        result.add(matrix[rowCursor][columnCursor]);

        return result;
    }
}
