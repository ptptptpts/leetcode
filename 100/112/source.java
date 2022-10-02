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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else {
            return findPathSum(root, targetSum, 0);
        }
    }

    private boolean findPathSum(TreeNode node, int targetSum, int currentSum) {
        boolean ret = false;
        currentSum = currentSum + node.val;

        if ((node.left == null) && (node.right == null)) {
            ret = targetSum == currentSum;
        } else {
            if (node.left != null) {
                ret = findPathSum(node.left, targetSum, currentSum);
            }
            if ((node.right != null) && !ret) {
                ret = findPathSum(node.right, targetSum, currentSum);
            }
        }

        return ret;
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
