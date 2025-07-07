class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(a-b));
        Arrays.sort(events, (a, b) -> (a[0]-b[0]));

        int idx = 0;
        int count = 0;
        int day = events[0][0];
        int len = events.length;

        while (!pq.isEmpty() || idx < len) {
            while (idx < len && events[idx][0] == day) {
                pq.offer(events[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return count;
    }
}