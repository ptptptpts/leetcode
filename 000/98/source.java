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
    public boolean isValidBST(TreeNode root) {
        int[] leftSubtree = postOrder(root.left, true);
        int[] rightSubtree = postOrder(root.right, false);

        return ((leftSubtree == null) || (root.val > leftSubtree[1]))
                && ((rightSubtree == null) || (root.val < rightSubtree[0]));
    }

    private int[] postOrder(TreeNode node, boolean isLeftSubtree) {
        if (node == null) {
            return null;
        }

        int[] minMaxArray = new int[] {node.val, node.val};
        int[] leftMinMaxArray = postOrder(node.left, true);
        int[] rightMinMaxArray = postOrder(node.right, false);

        if (((leftMinMaxArray == null) || (leftMinMaxArray[1] < node.val))
                && ((rightMinMaxArray == null) || (rightMinMaxArray[0] > node.val))) {
            if (leftMinMaxArray != null) {
                minMaxArray[0] = leftMinMaxArray[0];
            }
            if (rightMinMaxArray != null) {
                minMaxArray[1] = rightMinMaxArray[1];
            }
        } else {
            if (isLeftSubtree) {
                minMaxArray[0] = Integer.MAX_VALUE;
                minMaxArray[1] = Integer.MAX_VALUE;
            } else {
                minMaxArray[0] = Integer.MIN_VALUE;
                minMaxArray[1] = Integer.MIN_VALUE;
            }
        }

        return minMaxArray;
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
