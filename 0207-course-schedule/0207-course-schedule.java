class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = getAdj(prerequisites, in);
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : adj.get(u)) {
                if (--in[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return count == in.length;
    }

    private List<List<Integer>> getAdj(int[][] pre, int[] in) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int e[] : pre) {
            adj.get(e[1]).add(e[0]);
            in[e[0]]++;
        }
        return adj;
    }
}