import java.util.List;
import java.util.Stack;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        for (int cursor = 0; cursor < rooms.size(); cursor++) {
            visited[cursor] = false;
        }

        Stack<Integer> bfsStack = new Stack<>();
        bfsStack.push(0);
        while (!bfsStack.isEmpty()) {
            int roomNumber = bfsStack.pop();

            if (!visited[roomNumber]) {
                visited[roomNumber] = true;
                List<Integer> keysInRoom = rooms.get(roomNumber);
                for (Integer key : keysInRoom) {
                    if (!visited[key]) {
                        bfsStack.push(key);
                    }
                }
            }
        }

        boolean isAllVisited = true;
        for (int cursor = 0; cursor < rooms.size(); cursor++) {
            if (!visited[cursor]) {
                isAllVisited = false;
                break;
            }
        }
        return isAllVisited;
    }
}
