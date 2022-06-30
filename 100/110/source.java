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
    public boolean isBalanced(TreeNode root) {
        return checkHeightBalanced(root) != -1;
    }

    private int checkHeightBalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = checkHeightBalanced(node.left);
        int right = checkHeightBalanced(node.right);

        if ((left != -1) && (right != -1) && (Math.abs(left - right) < 2)) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}