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
        Node cursor = root;
        while (cursor != null) {
            Node previousNode = null;
            Node nextBaseNode = null;

            while (cursor != null) {
                previousNode = connectCursor(cursor.left, previousNode);
                if ((nextBaseNode == null) && (previousNode != null)) {
                    nextBaseNode = previousNode;
                }
                previousNode = connectCursor(cursor.right, previousNode);
                if ((nextBaseNode == null) && (previousNode != null)) {
                    nextBaseNode = previousNode;
                }
                cursor = cursor.next;
            }

            cursor = nextBaseNode;
        }

        return root;
    }

    private Node connectCursor(Node cursor, Node previousNode) {
        if (cursor != null) {
            if (previousNode != null) {
                previousNode.next = cursor;
            }
            previousNode = cursor;
        }
        return previousNode;
    }
}
