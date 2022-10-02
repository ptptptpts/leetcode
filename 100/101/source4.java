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
        return findSymmetric(root.left, root.right);
    }

    private boolean findSymmetric(TreeNode leftSide, TreeNode rightSide) {
        if ((leftSide == null) && (rightSide == null)) {
            return true;
        } else if ((leftSide == null) || (rightSide == null)) {
            return false;
        } else if (leftSide.val == rightSide.val) {
            boolean leftSymmetric = findSymmetric(leftSide.left, rightSide.right);
            boolean rightSymmetric = false;
            if (leftSymmetric) {
                rightSymmetric = findSymmetric(leftSide.right, rightSide.left);
            }
            return (leftSymmetric && rightSymmetric);
        } else {
            return false;
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
