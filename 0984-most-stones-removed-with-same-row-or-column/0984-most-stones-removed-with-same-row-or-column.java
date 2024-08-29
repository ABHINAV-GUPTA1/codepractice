class Solution {

    static List<Integer> emptyList = new ArrayList<>();
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    map.computeIfAbsent(i, c-> new ArrayList<>()).add(j);
                    map.computeIfAbsent(j, c-> new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, map, vis);
                connectedComponents++;
            }
        }

        return n - connectedComponents;
    }

    private void dfs(int u, Map<Integer, List<Integer>> map, boolean[] vis) {
        if (vis[u]) {
            return;
        }
        vis[u] = true;
        for (int v : map.getOrDefault(u, emptyList)) {
            if (!vis[v]) {
                dfs(v, map, vis);
            }
        }
    }
}