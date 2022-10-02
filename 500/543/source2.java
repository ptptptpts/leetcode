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
    private int mMaximumDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        mMaximumDiameter = 0;
        findDiameter(root);
        return mMaximumDiameter;
    }

    private int findDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = findDiameter(node.left);
            int rightDepth = findDiameter(node.right);
            mMaximumDiameter = Math.max(mMaximumDiameter, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

//    public static class TreeNode {
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
