class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] indeg = new int[quiet.length];
        return bfs(createAdj(richer, indeg), indeg, quiet);
    }

    private int[] bfs(Map<Integer, List<Integer>> adj, int[] indeg, int[] quiet) {
        int n = indeg.length;
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            res[i] = i;
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (adj.get(u) == null) {
                continue;
            }
            for (int v : adj.get(u)) {
                if (quiet[res[v]] > quiet[res[u]]) {
                    res[v] = res[u];
                }
                if (--indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return res;
    }

    private Map<Integer, List<Integer>> createAdj(int[][] rich, int[] indeg) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rich.length; i++) {
            map.computeIfAbsent(rich[i][0], x->new ArrayList<>()).add(rich[i][1]);
            indeg[rich[i][1]]++;
        }
        return map;
    }
}