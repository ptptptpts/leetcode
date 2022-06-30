import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> islandDataMap = new HashMap<Integer, Integer>();
        islandDataMap.put(0, 0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    writeIslandSize(grid, i, j, islandDataMap);
                }
            }
        }

        int largestIsland = 0;
        for (int size : islandDataMap.values()) {
            largestIsland = Math.max(largestIsland, size);
        }
        largestIsland = Math.max(largestIsland, findLargestIsland(grid, islandDataMap));

        return largestIsland;
    }

    private void writeIslandSize(int[][] grid, int i, int j, HashMap<Integer, Integer> islandDataMap) {
        int id = (islandDataMap.size()) * -1;

        Queue<int[]> visitorQueue = new LinkedList<int[]>();
        Queue<int[]> visitedQueue = new LinkedList<int[]>();

        visitorQueue.add(new int[]{i, j});
        while (!visitorQueue.isEmpty()) {
            int[] visitor = visitorQueue.poll();
            int visitorI = visitor[0];
            int visitorJ = visitor[1];

            if (grid[visitorI][visitorJ] == 1) {
                grid[visitorI][visitorJ] = id;

                if (visitorI > 0) {
                    if (grid[visitorI - 1][visitorJ] == 1) {
                        visitorQueue.add(new int[]{visitorI - 1, visitorJ});
                    }
                }
                if (visitorI < grid.length - 1) {
                    if (grid[visitorI + 1][visitorJ] == 1) {
                        visitorQueue.add(new int[]{visitorI + 1, visitorJ});
                    }
                }
                if (visitorJ > 0) {
                    if (grid[visitorI][visitorJ - 1] == 1) {
                        visitorQueue.add(new int[]{visitorI, visitorJ - 1});
                    }
                }
                if (visitorJ < grid.length - 1) {
                    if (grid[visitorI][visitorJ + 1] == 1) {
                        visitorQueue.add(new int[]{visitorI, visitorJ + 1});
                    }
                }

                visitedQueue.add(visitor);
            }
        }

        islandDataMap.put(id, visitedQueue.size());
    }

    private int findLargestIsland(int[][] grid, HashMap<Integer, Integer> islandDataMap) {
        int largestSize = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> nearIslands = new HashSet<Integer>();

                    if (i > 0) {
                        nearIslands.add(grid[i - 1][j]);
                    }
                    if (i < grid.length - 1) {
                        nearIslands.add(grid[i + 1][j]);
                    }
                    if (j > 0) {
                        nearIslands.add(grid[i][j - 1]);
                    }
                    if (j < grid.length - 1) {
                        nearIslands.add(grid[i][j + 1]);
                    }

                    int islandSize = 1;
                    for (Integer islandId : nearIslands) {
                        islandSize += islandDataMap.get(islandId);
                    }
                    largestSize = Math.max(largestSize, islandSize);
                }
            }
        }

        return largestSize;
    }
}
