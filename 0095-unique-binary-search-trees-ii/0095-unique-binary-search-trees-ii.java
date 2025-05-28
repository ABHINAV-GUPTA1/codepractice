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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = generate(left, i - 1);
            List<TreeNode> rightNodes = generate(i + 1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    res.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return res;
    }
}