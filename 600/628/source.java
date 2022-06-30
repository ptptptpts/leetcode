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
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> headList = new ArrayList<>();

        if (root != null) {
            postorder(0, headList, root);
        }

        return headList;
    }

    private void postorder(int level, List<List<Integer>> headList, TreeNode node) {
        List<Integer> levelList = null;
        if (headList.size() > level) {
            levelList = headList.get(level);
        }
        if (levelList == null) {
            levelList = new ArrayList<>();
            headList.add(level, levelList);
        }        

        if (node.left != null) {
            postorder(level + 1, headList, node.left);
        }
        if (node.right != null) {
            postorder(level + 1, headList, node.right);
        }

        levelList.add(node.val);
    }
}