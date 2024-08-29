class Solution {
    
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            if (rank[fa] >= rank[fb]) {
                parent[fb] = fa;
                rank[fa]++;
            } else {
                parent[fa] = fb;
                rank[fb]++; 
            }
        }


    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        int totalGroups = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                totalGroups++;
            }
        }

        return n - totalGroups;
    }

    static List<Integer> emptyList = new ArrayList<>();
    public int removeStones1(int[][] stones) {
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