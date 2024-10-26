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

    int level[];
    int height[];

    int firstMaxHt[];
    int secondMaxHt[];
    int MAX_N = 10_0001;
    public int[] treeQueries(TreeNode root, int[] queries) {
        level = new int[MAX_N];
        height = new int[MAX_N];
        firstMaxHt = new int[MAX_N];
        secondMaxHt = new int[MAX_N];

        findHt(root, 0);
        
        return getResultForQueries(queries);
    }

    private int[] getResultForQueries(int[] queries) {
        int ql = queries.length;
        int[] res = new int[ql];
        for (int i = 0; i < ql; i++) {
            int node = queries[i];
            int lvl = level[node];
            int tresult = lvl + (firstMaxHt[lvl] == height[node] ? secondMaxHt[lvl] : firstMaxHt[lvl]) - 1;
            res[i] = tresult;
        }

        return res;
    }

    private int findHt(TreeNode root, int lvl) {
        if (root == null) {
            return 0;
        }
        level[root.val] = lvl;
        int left = findHt(root.left, lvl+1);
        int right = findHt(root.right, lvl+1);
        height[root.val] = Math.max(left, right)+1;

        if (firstMaxHt[lvl] < height[root.val]) {
            secondMaxHt[lvl] = firstMaxHt[lvl];
            firstMaxHt[lvl] = height[root.val]; 
        } else if (secondMaxHt[lvl] < height[root.val]) {
            secondMaxHt[lvl] = height[root.val];
        }

        return height[root.val];
    }
}