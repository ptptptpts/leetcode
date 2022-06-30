import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] parents = new LinkedList[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (parents[prerequisite[0]] == null) {
                parents[prerequisite[0]] = new LinkedList<>();
            }
            parents[prerequisite[0]].add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < visited.length; i++) {
            if (parents[i] == null) {
                visited[i] = -1;
            } else {
                visited[i] = 0;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!searchTries(i, visited, parents)) {
                return false;
            }
        }

        return true;
    }

    private boolean searchTries(int course, int[] visited, LinkedList<Integer>[] parents) {
        if (visited[course] == -1) {
            return true;
        } else if (visited[course] == 1) {
            return false;
        } else {
            visited[course] = 1;

            for (int parent : parents[course]) {
                if (!searchTries(parent, visited, parents)) {
                    return false;
                }
            }

            visited[course] = -1;
            return true;
        }
    }
}
