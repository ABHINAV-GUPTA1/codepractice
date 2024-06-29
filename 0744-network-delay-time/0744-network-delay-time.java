class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.computeIfAbsent(times[i][0], x->new ArrayList<>()).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (!map.containsKey(arr[0])) {
                continue;
            }
            for (int[] v : map.get(arr[0])) {
                if (ans[v[0]] > v[1]+arr[1]) {
                    ans[v[0]] = arr[1]+v[1];
                    pq.offer(new int[]{v[0], arr[1]+v[1]});
                }
                
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(ans[i], res); 
        }
        return res == Integer.MAX_VALUE ? -1 : res; 
    }
}