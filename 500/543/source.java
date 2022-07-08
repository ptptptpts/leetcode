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
    private int mLongestDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        mLongestDiameter = 0;
        findLongestPath(root);
        return mLongestDiameter;
    }

    private int findLongestPath(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = findLongestPath(node.left);
            int right = findLongestPath(node.right);
            mLongestDiameter = Math.max(mLongestDiameter, left + right);
            return Math.max(left, right) + 1;
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