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
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        Queue<TreeNode> q;
        traverse(root, null, graph, leafNodes);
        Set<TreeNode> seen;
        int ans = 0;
        for (TreeNode leaf : leafNodes) {
            seen = new HashSet<>();
            q = new LinkedList<>();
            q.offer(leaf);
            seen.add(leaf);
            for (int j = 0; j <= distance; j++) {
                int sz = q.size();
                while (sz-- > 0) {
                    TreeNode t = q.poll();
                    if (leafNodes.contains(t) && t != leaf) {
                        ans++;
                    }
                    if (graph.containsKey(t)) {
                        for (TreeNode v : graph.get(t)) {
                            if (!seen.contains(v)) {
                                q.offer(v);
                                seen.add(v);
                            }
                        }
                    }
                }
            }
        }
        return ans/2;
    }

    private void traverse(TreeNode curr, TreeNode prev, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leaf) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            leaf.add(curr);
        }
        if (prev != null) {
            graph.computeIfAbsent(curr, x->new ArrayList<>()).add(prev);
            graph.computeIfAbsent(prev, x->new ArrayList<>()).add(curr);
        }
        traverse(curr.left, curr, graph, leaf);
        traverse(curr.right, curr, graph, leaf);
    }
}