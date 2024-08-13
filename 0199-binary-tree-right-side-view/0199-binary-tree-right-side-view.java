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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int val = 0;
            while (sz-- > 0) {
                TreeNode tmp = q.poll();
                val = tmp.val;
                if (tmp.left != null) {
                    q.offer(tmp.left);
                } 
                if (tmp.right != null) {
                    q.offer(tmp.right);
                } 
            }
            res.add(val);
        }
        return res;
    }
}