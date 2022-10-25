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
    public int minDepth(TreeNode root) {
        return findNearestLeafNode(root);
    }

    private int findNearestLeafNode(TreeNode node) {
        int level = 0;

        if (node != null) {
            int leftLength = findNearestLeafNode(node.left);
            int rightLength = findNearestLeafNode(node.right);

            if ((leftLength == 0) && (rightLength == 0)) {
                level = 1;
            } else {
                if ((leftLength * rightLength) == 0) {
                    level = leftLength + rightLength;
                } else {
                    level = Math.min(leftLength, rightLength);
                }
                level += 1;
            }
        }

        return level;
    }
}
