class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int tn = tasks.length;
        int[] res = new int[tn];
        PriorityQueue<int[]> availPq = new PriorityQueue<>((a,b)-> {
            if (a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        PriorityQueue<int[]> unavailPq = new PriorityQueue<>((a,b)-> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2]-b[2];
                }
                return a[1]-b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < servers.length; i++) {
            availPq.offer(new int[]{servers[i], i});
        }
        int t = 0;
        for (int i = 0; i < tasks.length; i++) {
            t = Math.max(t, i);
            int[] server;
            while (!unavailPq.isEmpty() && unavailPq.peek()[0] <= i) {
                server = unavailPq.poll();
                availPq.offer(new int[]{server[1], server[2]});
            }
            if (availPq.isEmpty()) {
                server = unavailPq.poll();
                if (server[0] > t) {
                    t = server[0];
                }
                res[i] = server[2];
                unavailPq.offer(new int[]{t+tasks[i], server[1], server[2]});
            } else {
                server = availPq.poll();
                res[i] = server[1];
                unavailPq.offer(new int[]{t+tasks[i], server[0], server[1]});
            }
        }

        return res;
    }
}