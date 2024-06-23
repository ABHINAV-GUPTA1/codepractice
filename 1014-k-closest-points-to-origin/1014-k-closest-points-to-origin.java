class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        /**
        Method 1 -> using min heap  
        
        
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)-> ((a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]) ) );

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
        */

        /**
            Method 2 -> using max heap
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> ((b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])) );
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}