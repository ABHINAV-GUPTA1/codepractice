class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            if (adj[i] == null) {
                adj[i] = new ArrayList<>();
            }
            if (manager[i] == -1) {
                continue;
            }
            if (adj[manager[i]] == null) {
                adj[manager[i]] = new ArrayList<>();
            }
            adj[manager[i]].add(i);
        }

        q.offer(new int[]{headID, 0});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int u = arr[0];
            int time = arr[1];
            res = Math.max(res, time);
            for (int v : adj[u]) {
                q.offer(new int[]{v, time + informTime[u]});
            }
        }
        return res;
    }
}