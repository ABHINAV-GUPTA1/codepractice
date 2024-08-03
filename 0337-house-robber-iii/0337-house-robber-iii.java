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
    public int rob(TreeNode root) {
        int[] res = getMaxFromTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] getMaxFromTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = getMaxFromTree(root.left);
        int[] right = getMaxFromTree(root.right);
        res[0] = root.val + left[1] + right[1]; // include root
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // exclude root

        return res;
    }
}