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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int sum = root.val;
        int ans = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;;
        while (!q.isEmpty()) {
            int sz = q.size();
            int levelSum = 0;
            while (sz-- > 0) {
                TreeNode t = q.poll();
                levelSum += t.val;
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            if (levelSum > sum) {
                ans = level;
                sum = levelSum;
            }
            level++;
        }

        return ans;
    }
}