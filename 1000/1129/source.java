import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static final int RED = 0;
    public static final int BLUE = 1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] redEdgesForEachNode = buildEdgesForEachNode(n, redEdges);
        ArrayList<Integer>[] blueEdgesForEachNode = buildEdgesForEachNode(n, blueEdges);

        int[] shortestDistancesFromRed = new int[n];
        int[] shortestDistancesFromBlue = new int[n];
        for (int cursor = 1; cursor < n; cursor++) {
            shortestDistancesFromRed[cursor] = -1;
            shortestDistancesFromBlue[cursor] = -1;
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        visitNodeByShortestPath(bfsQueue, shortestDistancesFromRed, redEdgesForEachNode, RED, 0, 1);
        visitNodeByShortestPath(bfsQueue, shortestDistancesFromBlue, blueEdgesForEachNode, BLUE, 0, 1);

        while (!bfsQueue.isEmpty()) {
            int[] nodeInformation = bfsQueue.poll();
            int node = nodeInformation[0];
            int previousColor = nodeInformation[1];
            int distance = nodeInformation[2];

            if (previousColor == RED) {
                visitNodeByShortestPath(
                        bfsQueue, shortestDistancesFromBlue, blueEdgesForEachNode, BLUE, node, distance + 1);
            } else {
                visitNodeByShortestPath(
                        bfsQueue, shortestDistancesFromRed, redEdgesForEachNode, RED, node, distance + 1);
            }
        }

        return combineShortestDistances(n, shortestDistancesFromRed, shortestDistancesFromBlue);
    }

    private ArrayList<Integer>[] buildEdgesForEachNode(int n, int[][] edges) {
        ArrayList<Integer>[] edgesForEachNode = new ArrayList[n];

        for (int cursor = 0; cursor < n; cursor++) {
            edgesForEachNode[cursor] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            edgesForEachNode[edge[0]].add(edge[1]);
        }

        return edgesForEachNode;
    }

    private void visitNodeByShortestPath(Queue<int[]> bfsQueue, int[] shortestDistances,
            ArrayList<Integer>[] edgesForEachNode, int color, int startingNode, int distance) {
        for (Integer to : edgesForEachNode[startingNode]) {
            if (shortestDistances[to] == -1) {
                bfsQueue.add(new int[] {to, color, distance});
                shortestDistances[to] = distance;
            }
        }
    }

    private int[] combineShortestDistances(int n, int[] shortestDistancesFromRed,
            int[] shortestDistancesFromBlue) {
        int[] shortestDistances = new int[n];

        for (int cursor = 0; cursor < n; cursor++) {
            int distanceFromRed = shortestDistancesFromRed[cursor];
            int distanceFromBlue = shortestDistancesFromBlue[cursor];

            if ((distanceFromRed >= 0) && (distanceFromBlue >= 0)) {
                shortestDistances[cursor] = Math.min(distanceFromRed, distanceFromBlue);
            } else if ((distanceFromRed == -1) && (distanceFromBlue == -1)) {
                shortestDistances[cursor] = -1;
            } else {
                shortestDistances[cursor] = Math.max(distanceFromRed, distanceFromBlue);
            }
        }

        return shortestDistances;
    }
}
