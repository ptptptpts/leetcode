import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> visited = new HashMap<>();
        return deepCopy(node, visited);
    }

    private Node deepCopy(Node node, HashMap<Integer, Node> visited) {
        if (!visited.containsKey(node.val)) {
            Node copy = new Node();
            copy.val = node.val;
            visited.put(copy.val, copy);

            for (Node neighbor : node.neighbors) {
                if (visited.containsKey(neighbor.val)) {
                    copy.neighbors.add(visited.get(neighbor.val));
                } else {
                    copy.neighbors.add(deepCopy(neighbor, visited));
                }
            }

            return copy;

        } else {
            return visited.get(node.val);
        }
    }

//    // Definition for a Node.
//    static class Node {
//        public int val;
//        public List<Node> neighbors;
//        public Node() {
//            val = 0;
//            neighbors = new ArrayList<Node>();
//        }
//        public Node(int _val) {
//            val = _val;
//            neighbors = new ArrayList<Node>();
//        }
//        public Node(int _val, ArrayList<Node> _neighbors) {
//            val = _val;
//            neighbors = _neighbors;
//        }
//    }
}
