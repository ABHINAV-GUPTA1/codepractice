class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>();
        int[] map = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                pq.offer(map[i]);
            }
        }
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time += 1;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) {
                    q.offer(new int[]{val, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                int[] val = q.poll();
                pq.offer(val[0]);
            }
        }

        return time;
    }
}