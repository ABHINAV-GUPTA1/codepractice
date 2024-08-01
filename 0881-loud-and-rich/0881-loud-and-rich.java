class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = quiet.length;
        int[] indegree = new int[n];
        for (int i = 0; i < richer.length; i++) {
            adj.computeIfAbsent(richer[i][0], x->new ArrayList<>()).add(richer[i][1]);
            indegree[richer[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int res[]  = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
            if (indegree[i] == 0) {
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
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return res;
    }
}