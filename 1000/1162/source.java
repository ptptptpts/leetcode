import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> bfsQueue = new LinkedList<>();
        int sumOfGrid = 0;
        for (int cursorM = 0; cursorM < m; cursorM++) {
            for (int cursorN = 0; cursorN < n; cursorN++) {
                if (grid[cursorM][cursorN] == 1) {
                    bfsQueue.add(new int[]{cursorM, cursorN, 0});
                }
                sumOfGrid += grid[cursorM][cursorN];
            }
        }

        if ((sumOfGrid == m * n) || (sumOfGrid == 0)) {
            return -1;
        }

        int maxDistance = 0;
        while (!bfsQueue.isEmpty()) {
            int[] currentPosition = bfsQueue.poll();
            int posM = currentPosition[0];
            int posN = currentPosition[1];
            int distance = currentPosition[2];

            maxDistance = Math.max(maxDistance, distance);

            if ((posM > 0) && (grid[posM - 1][posN] == 0)) {
                grid[posM - 1][posN] = 1;
                bfsQueue.add(new int[] {posM - 1, posN, distance + 1});
            }
            if ((posM < m - 1) && (grid[posM + 1][posN] == 0)) {
                grid[posM + 1][posN] = 1;
                bfsQueue.add(new int[] {posM + 1, posN, distance + 1});
            }
            if ((posN > 0) && (grid[posM][posN - 1] == 0)) {
                grid[posM][posN - 1] = 1;
                bfsQueue.add(new int[] {posM, posN - 1, distance + 1});
            }
            if ((posN < n - 1) && (grid[posM][posN + 1] == 0)) {
                grid[posM][posN + 1] = 1;
                bfsQueue.add(new int[] {posM, posN + 1, distance + 1});
            }
        }

        return maxDistance;
    }
}
