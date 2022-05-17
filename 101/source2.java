/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if ((left == null) && (right == null)) {
                continue;
            } else if (left == null) {
                return false;
            } else if (right == null) {
                return false;
            } else {
                if (left.val != right.val) {
                    return false;
                } else {
                    stack.push(left.left);
                    stack.push(right.right);
                    stack.push(left.right);
                    stack.push(right.left);
                    continue;
                }
            }
        }

        return true;
    }
}
