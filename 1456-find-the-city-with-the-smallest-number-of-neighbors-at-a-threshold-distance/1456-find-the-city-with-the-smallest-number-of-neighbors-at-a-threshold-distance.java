class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) { 
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
            dist[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]] = dist[edges[i][1]][edges[i][0]] = edges[i][2]; 
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                }
            }
        }
        int r = 0;
        int city = -1;
        int ans = (int)1e9;
        for (int i = 0; i < n; i++) {
            r = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    r++;
                }
            }
            if (r <= ans) {
                ans = r;
                city = i;
            }
            // System.out.println("i = "+i+ Arrays.toString(dist[i])+" =>"+r);
        }
        return city;
    }

    public int findTheCity1(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++)  {
            adj.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(new int[] {edges[i][1], edges[i][2]});
            adj.computeIfAbsent(edges[i][1], x->new ArrayList<>()).add(new int[] {edges[i][0], edges[i][2]});
        }
        int city = -1;
        PriorityQueue<Integer> pq;
        int[] dist;
        int max = (int)1e9;
        int cnt = max;
        for (int k = 0; k < n; k++) {
            pq = new PriorityQueue<>();
            dist = new int[n];
            Arrays.fill(dist, max);
            dist[k] = 0;
            pq.offer(k);
            while (!pq.isEmpty()) {
                int arr = pq.poll();
                if (!adj.containsKey(arr)) {continue;}
                for (int[] v : adj.get(arr)) {
                    if (dist[v[0]] > dist[arr] + v[1]) {
                        dist[v[0]] = dist[arr] + v[1];
                        if (dist[v[0]] <= distanceThreshold)
                        pq.offer(v[0]);
                    }
                }
            }
            int count = -1; // as dist from curr node is 0
            for (int x : dist) {
                if (x <= distanceThreshold) {
                    count++;
                }
            }
            // System.out.println("k is = " + k +" => "+Arrays.toString(dist));
            if (count <= cnt) {
                city = k;
                cnt = count;
            }
            // System.out.println(k +" "+count);
        }
        return city;
    }

}