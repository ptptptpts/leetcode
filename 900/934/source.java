import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        // Update the first island as '2'
        Queue<int[]> bfsQueue = updateFirstIsland(grid);

        // Find the shortest bridge to the second island
        return findDistanceOfShortestBridge(grid, bfsQueue);
    }

    private Queue<int[]> updateFirstIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> bfsQueue = new LinkedList<>();
        Queue<int[]> landQueue = new LinkedList<>();

        findFirstLand(grid, m, n, bfsQueue);

        while (!bfsQueue.isEmpty()) {
            int[] position = bfsQueue.poll();
            int posM = position[0];
            int posN = position[1];

            landQueue.add(new int[] {posM, posN, 0});

            if ((posM > 0) && (grid[posM - 1][posN] == 1)) {
                grid[posM - 1][posN] = 2;
                bfsQueue.add(new int[] {posM - 1, posN});
            }
            if ((posM < m - 1) && (grid[posM + 1][posN] == 1)) {
                grid[posM + 1][posN] = 2;
                bfsQueue.add(new int[] {posM + 1, posN});
            }
            if ((posN > 0) && (grid[posM][posN - 1] == 1)) {
                grid[posM][posN - 1] = 2;
                bfsQueue.add(new int[] {posM, posN - 1});
            }
            if ((posN < n - 1) && (grid[posM][posN + 1] == 1)) {
                grid[posM][posN + 1] = 2;
                bfsQueue.add(new int[] {posM, posN + 1});
            }
        }

        return landQueue;
    }

    private int findDistanceOfShortestBridge(int[][] grid, Queue<int[]> bfsQueue) {
        int m = grid.length;
        int n = grid[0].length;
        int shortestBridge = -1;

        while (!bfsQueue.isEmpty()) {
            int[] position = bfsQueue.poll();
            int posM = position[0];
            int posN = position[1];
            int distance = position[2];

            if (posM > 0) {
                shortestBridge = visitAdjacentCell(grid, bfsQueue, posM - 1, posN, distance);
                if (shortestBridge == distance) {
                    break;
                }
            }
            if (posM < m - 1) {
                shortestBridge = visitAdjacentCell(grid, bfsQueue, posM + 1, posN, distance);
                if (shortestBridge == distance) {
                    break;
                }
            }
            if (posN > 0) {
                shortestBridge = visitAdjacentCell(grid, bfsQueue, posM, posN - 1, distance);
                if (shortestBridge == distance) {
                    break;
                }
            }
            if (posN < n - 1) {
                shortestBridge = visitAdjacentCell(grid, bfsQueue, posM, posN + 1, distance);
                if (shortestBridge == distance) {
                    break;
                }
            }
        }
        return shortestBridge;
    }

    private int visitAdjacentCell(int[][] grid, Queue<int[]> bfsQueue, int nextM, int nextN,
            int distance) {
        int shortestBridge = -1;

        if (grid[nextM][nextN] == 0) {
            grid[nextM][nextN] = 2;
            bfsQueue.add(new int[] {nextM, nextN, distance + 1});
        } else if (grid[nextM][nextN] == 1) {
            shortestBridge = distance;
        }

        return shortestBridge;
    }

    private void findFirstLand(int[][] grid, int m, int n, Queue<int[]> bfsQueue) {
        for (int cursorM = 0; cursorM < m; cursorM++) {
            boolean isFind = false;
            for (int cursorN = 0; cursorN < n; cursorN++) {
                if (grid[cursorM][cursorN] == 1) {
                    grid[cursorM][cursorN] = 2;
                    bfsQueue.add(new int[] {cursorM, cursorN});
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
    }
}
