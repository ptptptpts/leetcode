import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        preorderTraversal(root, 0, ret);

        return ret;
    }

    private void preorderTraversal(TreeNode node, int level, List<List<Integer>> ret) {
        if (node != null) {
            if (ret.size() <= level) {
                ret.add(new LinkedList<>());
            }

            List<Integer> currentLevel = ret.get(level);
            currentLevel.add(node.val);
            preorderTraversal(node.left, level + 1, ret);
            preorderTraversal(node.right, level + 1, ret);
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