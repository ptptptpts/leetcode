/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // This problem gives the root of a binary tree and return true if the tree is symmetric.

        // A number of nodes in the given tree is 1 <= n <= 1000
        // A range of a value of each node is -100 <= n <= 100

        // If the given tree is symmetric, it means we can find the same tree when we traverse a
        // left and right child of the root.
        // So, we can decide the given tree is symmetric or not by traverse its left and right
        // child and compare them.
        // To compare both trees, we will use a pre-order traversal and compare a value of current
        // node with left and right child.

        // A time complexity is O(n) because we need to traverse all the nodes in the tree.
        // A space complexity is O(n) because we will use a pre-order traversal
        return compareNodes(root.left, root.right);
    }

    private boolean compareNodes(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        } else if ((left == null) || (right == null)) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            if (compareNodes(left.left, right.right)) {
                if (compareNodes(left.right, right.left)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
}
