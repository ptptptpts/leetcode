import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        TreeNode currentCheckNode = root;
        LinkedList<TreeNode> middleStack = new LinkedList<TreeNode>();

        while ((currentCheckNode != null) || !middleStack.isEmpty()) {
            if (currentCheckNode != null) {
                middleStack.push(currentCheckNode);
                if (currentCheckNode.left != null) {
                    currentCheckNode = currentCheckNode.left;
                } else {
                    currentCheckNode = null;
                }
            } else {
                TreeNode node = middleStack.pop();
                result.add(node.val);
                if (node.right != null) {
                    currentCheckNode = node.right;
                }
            }
        }

        return result;
    }
}
