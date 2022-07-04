import java.util.HashMap;

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
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positions.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);

        createNode(preorder, inorder, root, 1, 0, positions.get(preorder[0]),
                inorder.length, positions);

        return root;
    }

    private int createNode(int[] preorder, int[] inorder, TreeNode parent, int cursor, int start,
            int middle, int end, HashMap<Integer, Integer> positions) {
        if (cursor >= preorder.length){
            return cursor;
        }

        int currentVal = preorder[cursor];
        int currentValLocation = positions.get(currentVal);

        if ((currentValLocation < start) || (currentValLocation >= end)) {
            return cursor;
        } else {
            TreeNode newNode = new TreeNode(currentVal);

            cursor++;
            if (currentValLocation < middle) {
                parent.left = newNode;
                cursor = createNode(preorder, inorder, newNode, cursor, start, currentValLocation,
                        middle, positions);
                cursor = createNode(preorder, inorder, parent, cursor, start, middle, end,
                        positions);
            } else {
                parent.right = newNode;
                cursor = createNode(preorder, inorder, newNode, cursor, middle + 1,
                        currentValLocation, end, positions);
            }

            return cursor;
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