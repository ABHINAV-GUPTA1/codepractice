class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], x->new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], x->new ArrayList<>()).add(e[0]);
        }

        int[] intime = new int[n];
        int[] outtime = new int[n];
        int[] subxor = new int[n];
        dfs(0, -1, nums, intime, outtime, subxor, map, new int[1]);
        int res = Integer.MAX_VALUE;
        for (int node1 = 1; node1 < n; node1++) {
            for (int node2 = node1 + 1; node2 < n; node2++) {
                int xor1;
                int xor2;
                int xor3;
                if (isAncestor(node1, node2, intime, outtime)) {
                    xor1 = subxor[node2];
                    xor2 = subxor[node1] ^ subxor[node2];
                    xor3 = subxor[0] ^ xor1 ^ xor2;
                } else if (isAncestor(node2, node1, intime, outtime)) {
                    xor1 = subxor[node1];
                    xor2 = subxor[node1] ^ subxor[node2];
                    xor3 = subxor[0] ^ xor1 ^ xor2;
                } else {
                    xor1 = subxor[node1];
                    xor2 = subxor[node2];
                    xor3 = subxor[0] ^ xor1 ^ xor2;
                }
                res = Math.min(res, getMin(xor1, xor2, xor3));
            }
        }
        return res;
    }

    private int getMin(int u, int v, int x) {
        int max = Math.max(u, Math.max(v, x));
        int min = Math.min(u, Math.min(v, x));
        return max - min;
    }

    private boolean isAncestor(int u, int v, int[] in, int[] out) {
        // in[u] = 0
        // in[v] = 1;
        // out[v] = 2
        // out[u] = 4 

        return in[u]<=in[v] && out[u] >= out[v];
           

    }

    private void dfs (int node, int parent, int[] nums, int[] in, int[] out, int[] xor, Map<Integer, List<Integer>> map, int[] timer) {
        in[node] = timer[0]++;
        xor[node] = nums[node];
        if (map.containsKey(node)) {
            for (int nbr : map.get(node)) {
                if (nbr != parent) {
                    dfs(nbr, node, nums, in, out, xor, map, timer);
                    xor[node] ^= xor[nbr];
                }
            }
        }
        out[node] = timer[0]++;
    }
}