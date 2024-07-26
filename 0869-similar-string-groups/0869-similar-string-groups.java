class Solution {
    
    int[] parent;
    int[] rank;
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int u, int v) {
        int ux = find(u);
        int vx = find(v);
        if (ux == vx) {
            return;
        }
        if (rank[ux] < rank[vx]) {
            parent[ux] = vx; 
            rank[vx] += 1;
        } else {
            parent[vx] = ux; 
            rank[ux] += 1;
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int ans = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) && find(i) != find(j)) {
                    ans--;
                    union(i, j);
                }
            }
        }
        return ans;
    }

    public int numSimilarGroups1(String[] strs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = strs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    map.computeIfAbsent(i,x->new ArrayList<>()).add(j);
                    map.computeIfAbsent(j,x->new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i, map, vis);
                ans++;
            }
        }
        return ans;
    }

    private void bfs(int x, Map<Integer, List<Integer>> map, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        vis[x] = true;
        if (map.get(x) == null) {
            return;
        }
        while (!q.isEmpty()) {
            x = q.poll();
            vis[x] = true;
            if (map.get(x) == null) {
                continue;
            }
            for (int v : map.get(x)) {
                if (!vis[v]) {
                    q.offer(v);
                }
            }
        }
        for (int v : map.get(x)) {
            if (!vis[v]) {
                bfs(v, map, vis);
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int ans = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                ans++;
            }
        }

        return ans == 2 || ans == 0;
    }

    private void dfs(int x, Map<Integer, List<Integer>> map, boolean[] vis) {
        if (vis[x]) {
            return;
        }
        vis[x] = true;
        if (map.get(x) == null) {
            return;
        }
        for (int v : map.get(x)) {
            if (!vis[v]) {
                dfs(v, map, vis);
            }
        }
    }
}