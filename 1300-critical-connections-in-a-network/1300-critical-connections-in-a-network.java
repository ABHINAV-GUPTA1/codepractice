class Solution {
    List<List<Integer>> res;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < connections.size(); i++) {
            map.computeIfAbsent(connections.get(i).get(0), x->new ArrayList<>()).add(connections.get(i).get(1));
            map.computeIfAbsent(connections.get(i).get(1), x->new ArrayList<>()).add(connections.get(i).get(0));
        }
        time = 1;
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        dfs(0, -1, vis, tin, low, map);

        return res;
    }

    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, Map<Integer, List<Integer>> graph) {
        vis[node] = true;
        tin[node] = time++;
        low[node] = tin[node];
        if (graph.get(node) == null) {
            return;
        }
        for (int it : graph.get(node)) {
            if (it == parent) {
                continue;
            }
            if (!vis[it]) {
                dfs(it, node, vis, tin, low, graph);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) {
                    res.add(Arrays.asList(it, node));
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}