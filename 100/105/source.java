import java.util.Arrays;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        createNode(preorder, inorder, root, 1, 0, findPositionInInorder(preorder[0], inorder),
                inorder.length);

        return root;
    }

    private int createNode(int[] preorder, int[] inorder, TreeNode parent, int cursor, int start,
            int middle, int end) {
        if (cursor >= preorder.length){
            return cursor;
        }

        int currentVal = preorder[cursor];
        int currentValLocation = findPositionInInorder(currentVal, inorder);

        if ((currentValLocation < start) || (currentValLocation >= end)) {
            return cursor;
        } else {
            TreeNode newNode = new TreeNode(currentVal);

            cursor++;
            if (currentValLocation < middle) {
                parent.left = newNode;
                cursor = createNode(preorder, inorder, newNode, cursor, start, currentValLocation,
                        middle);
                cursor = createNode(preorder, inorder, parent, cursor, start, middle, end);
            } else {
                parent.right = newNode;
                cursor = createNode(preorder, inorder, newNode, cursor, middle + 1,
                        currentValLocation, end);
            }

            return cursor;
        }
    }

    private int findPositionInInorder(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
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