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
    private int mCoinMoves;

    public int distributeCoins(TreeNode root) {
        mCoinMoves = 0;
        distribute(root);
        return mCoinMoves;
    }

    private int distribute(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftCoins = distribute(node.left);
        int rightCoins = distribute(node.right);

        // Distribute the coins to children
        // Move the additional coins to parent
        mCoinMoves += Math.abs(leftCoins) + Math.abs(rightCoins);

        // Share a number of additional coins or not enough coins to its parent
        return node.val + leftCoins + rightCoins - 1;
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
