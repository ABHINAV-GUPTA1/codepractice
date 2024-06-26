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
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }    
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return solve(0, res.size()-1, res);
    }

    private TreeNode solve(int l, int r, List<Integer> res) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = solve(l, mid-1, res);
        root.right = solve(mid+1, r, res);
        return root;
    }
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}