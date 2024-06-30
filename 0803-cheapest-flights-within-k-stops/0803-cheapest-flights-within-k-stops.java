class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans = new int[n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < flights.length; i++) {
            map.computeIfAbsent(flights[i][0], x->new ArrayList<>()).add(new int[]{flights[i][1], flights[i][2]});
        }
        int tmp[] = {src, 0, 0};
        q.offer(tmp);
        int[] qp;
        Arrays.fill(ans, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            qp = q.poll();
            if (qp[2] > k+1) {
                continue;
            }
            ans[qp[0]] = Math.min(qp[1], ans[qp[0]]);
            if (map.get(qp[0]) == null) {
                continue;
            }
            for (int[] adjm : map.get(qp[0]) ) {
                if (qp[1]+adjm[1] < ans[adjm[0]] && qp[2] <= k) {
                    tmp = new int[]{adjm[0], qp[1]+adjm[1], qp[2]+1};
                    q.offer(tmp);
                }
            }
        }
        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
}