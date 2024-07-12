class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++)  {
            map.computeIfAbsent(queries[i], x->new ArrayList<>()).add(i);
        }   
        Arrays.sort(queries);

        int idx = 0;
        int i = 0;
        int intervalLen = intervals.length;
        int queryLen = queries.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int val;

        int res[] = new int[queryLen];
        while (idx < queryLen) {
            while (i < intervalLen && queries[idx] >= intervals[i][0]) {
                pq.offer(new int[]{intervals[i][1]-intervals[i][0]+1, intervals[i][1]});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < queries[idx]) {
                pq.poll();
            }
            val = pq.isEmpty() ? -1 : pq.peek()[0];
            for (int k : map.get(queries[idx])) {
                res[k] = val;
            }
            idx++;
        }

        return res;
    }
}