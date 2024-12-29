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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode tmp;
        while (!q.isEmpty()) {
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;
            while (size-- > 0) {
                tmp = q.poll();
                maxVal = Math.max(maxVal, tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            ans.add(maxVal);
        }
        return ans;
    }
}