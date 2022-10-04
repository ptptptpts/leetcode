import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distanceMatrix = initializeDistanceMatrix(m, n);
        buildDistanceMatrix(mat, distanceMatrix);
        return distanceMatrix;
    }

    private int[][] initializeDistanceMatrix(int m, int n) {
        // Initialize the return matrix as -1
        int[][] distanceMatrix = new int[m][n];

        for (int mCursor = 0; mCursor < m; mCursor++) {
            for (int nCursor = 0; nCursor < n; nCursor++) {
                distanceMatrix[mCursor][nCursor] = -1;
            }
        }

        return distanceMatrix;
    }

    private void buildDistanceMatrix(int[][] matrix, int[][] distanceMatrix) {
        int m = distanceMatrix.length;
        int n = distanceMatrix[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>();

        findAllZeroCells(matrix, bfsQueue);

        // Pop the position until the queue is empty
        // Fill the current position as a current level
        // Push near cells if it is -1
        // Swap the next queue with a current queue
        while (!bfsQueue.isEmpty()) {
            int[] position = bfsQueue.poll();
            int posM = position[0];
            int posN = position[1];
            int level = position[2];

            if (distanceMatrix[posM][posN] == -1) {
                distanceMatrix[posM][posN] = level;
                if (posM > 0) {
                    bfsQueue.add(new int[]{posM - 1, posN, level + 1});
                }
                if (posM < m - 1) {
                    bfsQueue.add(new int[]{posM + 1, posN, level + 1});
                }
                if (posN > 0) {
                    bfsQueue.add(new int[]{posM, posN - 1, level + 1});
                }
                if (posN < n - 1) {
                    bfsQueue.add(new int[]{posM, posN + 1, level + 1});
                }
            }
        }
    }

    private void findAllZeroCells(int[][] mat, Queue<int[]> currentQueue) {
        int m = mat.length;
        int n = mat[0].length;

        // Initialize the queue by the position of 0
        for (int cursorM = 0; cursorM < m; cursorM++) {
            for (int cursorN = 0; cursorN < n; cursorN++) {
                if (mat[cursorM][cursorN] == 0) {
                    currentQueue.add(new int[]{cursorM, cursorN, 0});
                }
            }
        }
    }
}