class Solution {
    
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], x->new ArrayList<>()).add(edges[i][0]);
        }
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1}); //node, stepCount
        d1[1] = 0;
        int timePassed = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int node = tmp[0];
            int stepCount = tmp[1];
            if (node == n && stepCount == 2) {
                return d2[n];
            }
            timePassed = stepCount == 2 ? d2[node] : d1[node];

            int lightChange = timePassed / change;
            if (lightChange%2 == 1) {
                timePassed = (lightChange+1) * change;
            }
            if (adj.get(node) == null) {
                continue;
            }
            for (int v : adj.get(node)) {
                int val = timePassed+time;
                if (d1[v] == Integer.MAX_VALUE) {
                    d1[v] = val;
                    q.offer(new int[]{v, 1});
                } else if (d2[v] == Integer.MAX_VALUE && d1[v] != val) {
                    d2[v] = val;
                    q.offer(new int[]{v, 2});
                }
            }
        }

        return -1;
    }

    public int secondMinimum1(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], x->new ArrayList<>()).add(edges[i][0]);
        }
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{1, 0});// node, timePassed
        d1[0] = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0];
            int timePassed = tmp[1];
            if (node == n && d2[n] != Integer.MAX_VALUE) {
                return d2[n];
            }
            int lightChange = timePassed / change;
            if (lightChange%2 == 1) {
                timePassed = (lightChange+1) * change;
            }
            if (adj.get(node) == null) {
                continue;
            }
            for (int v : adj.get(node)) {
                int newTime = timePassed+time;
                if (d1[v] > newTime) {
                    d2[v] = d1[v];
                    d1[v] = newTime;
                    pq.offer(new int[]{v, newTime});
                } else if (d2[v] > newTime && d1[v] != newTime) {
                    d2[v] = newTime;
                    pq.offer(new int[]{v, newTime});
                }
            }
        }

        return -1;
    }
}