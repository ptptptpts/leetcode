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
        return compareLeftRight(root.left, root.right);
    }

    private boolean compareLeftRight(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                boolean ret = compareLeftRight(left.left, right.right);
                ret &= compareLeftRight(left.right, right.left);
                return ret;
            }
        }
    }
}
