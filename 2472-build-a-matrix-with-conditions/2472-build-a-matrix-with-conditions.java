class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];
        int[] row = topologicalSort(rowConditions, k);
        int[] col = topologicalSort(colConditions, k);
        if (row == null || col == null) {
            return new int[0][];
        }
        // System.out.println(Arrays.toString(row));
        // System.out.println(Arrays.toString(col));

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (row[i+1] == col[j+1]) {
                    res[i][j] = row[i+1];
                }
            }
        }

        return res;

    }

    private int[] topologicalSort(int[][] row, int k) {
        int[] ans = new int[k+1];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[k+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < row.length; i++) {
            adj.computeIfAbsent(row[i][0],x->new ArrayList<>()).add(row[i][1]);
            indegree[row[i][1]]++; 
        }

        for (int i = 0; i <= k; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int j = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            ans[j++] = u;
            if (adj.get(u) == null) {
                continue;
            }
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        
        if (j-1 != k) {
            return null;
        }
        return ans;
    }
}