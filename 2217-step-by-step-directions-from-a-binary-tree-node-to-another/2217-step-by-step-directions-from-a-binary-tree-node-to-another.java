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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        if (root == null) {
            return "";
        }   

        StringBuilder rootToSrcPath = new StringBuilder();
        findPath(root, startValue, rootToSrcPath);

        StringBuilder rootToDstPath = new StringBuilder();
        findPath(root, destValue, rootToDstPath);

        StringBuilder res = new StringBuilder();
        
        int i = 0;
        int in = rootToSrcPath.length();
        int j = 0;
        int jn = rootToDstPath.length();
        while (i < in && j < jn && rootToSrcPath.charAt(i) == rootToDstPath.charAt(j)) {
            i++;
            j++;
        }

        while (i < in) {
            res.append("U");
            i++;
        }

        while (j < jn) {
            res.append(rootToDstPath.charAt(j++));
        }

        return res.toString();
    }

    public String getDirections1(TreeNode root, int startValue, int destValue) {
        
        TreeNode lca = lca(root, startValue, destValue); 
        if (lca == null) {
            return "";
        }   

        StringBuilder rootToSrcPath = new StringBuilder();
        findPath(lca, startValue, rootToSrcPath);

        StringBuilder rootToDstPath = new StringBuilder();
        findPath(lca, destValue, rootToDstPath);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rootToSrcPath.length(); i++) {
            res.append("U");
        }

        res.append(rootToDstPath);

        return res.toString();
    }

    private boolean findPath(TreeNode root, int val, StringBuilder sb) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }
        sb.append("L");
        if (findPath(root.left, val, sb)) {
            return true;
        }
        sb.setLength(sb.length()-1);

        sb.append("R");
        if (findPath(root.right, val, sb)) {
            return true;
        }
        sb.setLength(sb.length()-1);
        return false;
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}