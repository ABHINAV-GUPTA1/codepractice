class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        List<Integer> topoSort = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            res.add(new HashSet<>());
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topoSort.add(u);
            if (map.get(u) == null) {
                continue;
            }
            for (int v : map.get(u)) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int node = topoSort.get(i);
            if (map.get(node) == null) {
                continue;
            }
            for (int v : map.get(node)) {
                res.get(v).add(node);
                res.get(v).addAll(res.get(node));
            }
        }

        
        
        return res.stream()
                .map(set -> set.stream().sorted().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}