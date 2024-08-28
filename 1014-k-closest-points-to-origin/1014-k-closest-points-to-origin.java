class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(-(a[0]*a[0]+a[1]*a[1])+(b[0]*b[0]+b[1]*b[1])));
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        return res.toArray(new int[res.size()][]);
    }
}