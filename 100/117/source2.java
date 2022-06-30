/*
 * // Definition for a Node. class Node { public int val; public Node left; public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) { val = _val; left = _left; right =
 * _right; next = _next; } };
 */

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cursor = root;
        Node nextRoot = null;
        Node previousCursor = null;
        while (cursor != null) {
            if (cursor.left != null) {
                if (previousCursor != null) {
                    previousCursor.next = cursor.left;
                }
                previousCursor = cursor.left;

                if (nextRoot == null) {
                    nextRoot = cursor.left;
                }
            }

            if (cursor.right != null) {
                if (previousCursor != null) {
                    previousCursor.next = cursor.right;
                }
                previousCursor = cursor.right;

                if (nextRoot == null) {
                    nextRoot = cursor.right;
                }
            }

            cursor = cursor.next;
        }

        if (nextRoot != null) {
            connect(nextRoot);
        }

        return root;
    }
}
