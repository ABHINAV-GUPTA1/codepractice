class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Map<Integer, List<int[]>> map = new HashMap<>();
        // int n = points.length;
        // for 
        // (int i = 0; i < n; i++) {
        //     for (int j = i+1; j < n; j++) {
        //         int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
        //         map.computeIfAbsent(i,x->new ArrayList<>()).add(new int[]{j, dist});
        //         map.computeIfAbsent(j,x->new ArrayList<>()).add(new int[]{i, dist});
        //     }
        // }

        // return prims(map, n);

        List<int[]> adj = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.add(new int[]{i, j, dist});
                adj.add(new int[]{j, i, dist});
            }
        }
        return kruskal(adj, n);
    }

    private int kruskal(List<int[]> adj, int n) {
        int sum = 0;
        Collections.sort(adj, (x,y)->x[2]-y[2]);
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < adj.size(); i++) {
            int arr[] = adj.get(i);
            int ux = arr[0];
            int uy = arr[1];
            int udist = arr[2];
            
            int px = find(ux);
            int py = find(uy);
            if (px != py) {
                union(px, py);
                sum += udist;
            }
        }

        return sum;
    }

    int[] parent;
    int[] rank;
    int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
            rank[pa]++;
        } else {
            parent[pa] = pb;
            rank[pb]++;
        }
    }

    private int prims(Map<Integer, List<int[]>> map, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(Integer.compare(a[1],b[1])));
        boolean[] visit = new boolean[n];
        int[] parent = new int[n];
        pq.offer(new int[]{0,0});
        int sum = 0;
        while (!pq.isEmpty()) {
            int arr[] = pq.poll();
            if (visit[arr[0]]) {
                continue;
            }
            visit[arr[0]] = true;
            int u = arr[0];
            int dist = arr[1];
            sum += dist;
            List<int[]> list = map.get(u);
            if (list == null) {
                continue;
            }
            for (int[] v : list) {
                if (!visit[v[0]]) {
                    pq.offer(new int[]{v[0], v[1]});
                }
            }
        }

        return sum;
    }
}