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
    int numberOfGoodNodes = 1;

    public int goodNodes(TreeNode root) {
        numberOfGoodNodes = 1;
        pushChildsIfGoodNode(root);
        return numberOfGoodNodes;
    }

    private void pushChildsIfGoodNode(TreeNode parent) {
        if (parent.left != null) {
            if (parent.left.val >= parent.val) {
                numberOfGoodNodes += 1;
            } else {
                parent.left.val = parent.val;
            }
            pushChildsIfGoodNode(parent.left);
        }
        if (parent.right != null) {
            if (parent.right.val >= parent.val) {
                numberOfGoodNodes += 1;
            } else {
                parent.right.val = parent.val;
            }
            pushChildsIfGoodNode(parent.right);
        }
    }
}