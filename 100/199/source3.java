import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        preOrder(root, rightSideView, 0);
        return rightSideView;
    }

    private void preOrder(TreeNode node, List<Integer> rightSideView, int level) {
        if (node != null) {
            if (rightSideView.size() == level) {
                rightSideView.add(node.val);
            }
            preOrder(node.right, rightSideView, level + 1);
            preOrder(node.left, rightSideView, level + 1);
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
