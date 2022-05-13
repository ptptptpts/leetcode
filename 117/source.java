/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Node> nodesList = new ArrayList<>();
        ArrayList<Node> currentLevelNodes = new ArrayList<>();
        currentLevelNodes.add(root);
        while (!currentLevelNodes.isEmpty()) {
            ArrayList<Node> nextLevelNodes = new ArrayList<>();

            for (Node node: currentLevelNodes) {
                nodesList.add(node);
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            nodesList.add(null);
            currentLevelNodes = nextLevelNodes;
        }
        
        Node previousCursor = null;
        for (Node node : nodesList) {
            if (previousCursor != null) {
                previousCursor.next = node;
            }
            previousCursor = node;
        }

        return root;
    }
}
