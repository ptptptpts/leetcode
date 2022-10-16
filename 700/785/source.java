class Solution {
    public boolean isBipartite(int[][] graph) {
        // Visit nodes by DFS and mark this node is in set A or set B
        // If a current node is in a set A, the nodes connected with the current node will be a set B
        // If a current node is connected with the node in the same set, this graph can't be bipartite
        boolean[] isVisited = new boolean[graph.length];
        boolean[] isSetA = new boolean[graph.length];
        boolean[] isSetB = new boolean[graph.length];

        for (int cursor = 0; cursor < graph.length; cursor++) {
            isVisited[cursor] = false;
            isSetA[cursor] = false;
            isSetB[cursor] = false;
        }

        // Traverse by DFS
        for (int cursor = 0; cursor < graph.length; cursor++) {
            if (!isVisited[cursor]) {
                int[] edges = graph[cursor];
                if ((edges == null) || (edges.length == 0)) {
                    isVisited[cursor] = true;
                    isSetA[cursor] = true;
                } else {
                    traverseAllEdges(graph, isVisited, isSetA, isSetB, cursor, true);
                }
            }
        }

        // If the graph can't be bipartite, some nodes are in both set A and set B
        boolean isBipartite = true;
        for (int cursor = 0; cursor < graph.length; cursor++) {
            if (isSetA[cursor] && isSetB[cursor]) {
                isBipartite = false;
                break;
            }
        }
        return isBipartite;
    }

    private void traverseAllEdges(int[][] graph, boolean[] isVisited, boolean[] isSetA,
            boolean[] isSetB, int nodeNumber, boolean isSetANode) {
        if (isSetANode) {
            isSetA[nodeNumber] = true;
        } else {
            isSetB[nodeNumber] = true;
        }

        if (!isVisited[nodeNumber]) {
            isVisited[nodeNumber] = true;
            for (int connectedNodes : graph[nodeNumber]) {
                traverseAllEdges(graph, isVisited, isSetA, isSetB, connectedNodes, !isSetANode);
            }
        }
    }
}
