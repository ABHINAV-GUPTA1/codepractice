class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) {
                continue;
            }
            pq.offer(x-y);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}