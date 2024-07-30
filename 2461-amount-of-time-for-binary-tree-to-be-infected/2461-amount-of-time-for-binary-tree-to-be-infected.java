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
    int res;
    public int amountOfTime(TreeNode root, int start) { 
        res = Integer.MIN_VALUE;
        solve(root, start);
        return res;
    }

    private int solve(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        int lh = solve(root.left, start);
        int rh = solve(root.right, start);

        if (root.val == start) {
            res = Math.max(lh, rh);
            return -1;
        } else if (lh >= 0 && rh >= 0) {
            return 1 + Math.max(lh, rh);
        } else {
            int dist = Math.abs(lh) + Math.abs(rh);
            res = Math.max(res, dist);
            return Math.min(lh, rh) - 1;
        }
    } 
    public int amountOfTime1(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        createAdj(root, -1, map);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int minute = 0;
        Set<Integer> vis = new HashSet<>();
        vis.add(start);
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int u = q.poll();
                
                for (int v : map.getOrDefault(u, Collections.emptyList())) {
                    if (!vis.contains(v)) {
                        vis.add(v);
                        q.offer(v);
                    }    
                }
            }
            minute++;
        }

        return minute-1;
    }

    private void createAdj(TreeNode root, int parent, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        if (parent != -1) {
            map.computeIfAbsent(root.val, x->new ArrayList<>()).add(parent);
        }
        if (root.left != null) {
            map.computeIfAbsent(root.val, x->new ArrayList<>()).add(root.left.val);
        }
        if (root.right != null) {
            map.computeIfAbsent(root.val, x->new ArrayList<>()).add(root.right.val);
        }

        createAdj(root.left, root.val, map);
        createAdj(root.right, root.val, map);
    }

}