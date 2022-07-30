import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ret = new ArrayList<>();
        findDistanceNodes(root, target.val, k, -1, ret);
        return ret;
    }

    private int findDistanceNodes(TreeNode node, int target, int distanceK, int currentDistance,
            List<Integer> ret) {
        if (node == null) {
            return currentDistance;
        }

        if (currentDistance == -1) {
            if (node.val == target) {
                currentDistance = 0;
                if (currentDistance == distanceK) {
                    ret.add(node.val);
                } else if (currentDistance < distanceK) {
                    findDistanceNodes(node.left, target, distanceK, currentDistance + 1, ret);
                    findDistanceNodes(node.right, target, distanceK, currentDistance + 1, ret);
                }
            } else {
                if (currentDistance == -1) {
                    currentDistance = findDistanceNodes(node.left, target, distanceK,
                            currentDistance, ret);
                    if (currentDistance != -1) {
                        if (currentDistance == distanceK) {
                            ret.add(node.val);
                        } else if (currentDistance < distanceK) {
                            findDistanceNodes(node.right, target, distanceK, currentDistance + 1,
                                    ret);
                        }
                    }
                }
                if (currentDistance == -1) {
                    currentDistance = findDistanceNodes(node.right, target, distanceK,
                            currentDistance, ret);
                    if (currentDistance != -1) {
                        if (currentDistance == distanceK) {
                            ret.add(node.val);
                        } else if (currentDistance < distanceK) {
                            findDistanceNodes(node.left, target, distanceK, currentDistance + 1,
                                    ret);
                        }
                    }
                }
            }
        } else {
            if (currentDistance == distanceK) {
                ret.add(node.val);
            } else if (currentDistance < distanceK) {
                findDistanceNodes(node.left, target, distanceK, currentDistance + 1, ret);
                findDistanceNodes(node.right, target, distanceK, currentDistance + 1, ret);
            }
        }

        if (currentDistance == -1) {
            return -1;
        } else {
            return currentDistance + 1;
        }
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
}