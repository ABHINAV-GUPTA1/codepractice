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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            toDeleteSet.add(to_delete[i]);
        }
        findDeleteNodes(root, toDeleteSet, res);
        if (!toDeleteSet.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    TreeNode findDeleteNodes(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> res) {
        if (root == null) {
            return root;
        }
        TreeNode left = findDeleteNodes(root.left, toDeleteSet, res);
        TreeNode right = findDeleteNodes(root.right, toDeleteSet, res);
        if (toDeleteSet.contains(root.val)) {
            root.left = null;
            root.right = null;
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}