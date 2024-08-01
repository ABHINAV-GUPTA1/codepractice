class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        PriorityQueue<int[]> availPq = new PriorityQueue<>((a,b)-> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<int[]> unavailPq = new PriorityQueue<>((a,b)->{
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < servers.length; i++) {
            availPq.offer(new int[]{servers[i], i});
        }
        int t = 0;
        int val[];
        for (int i = 0; i < n; i++) {
            t = Math.max(t, i);
            while (!unavailPq.isEmpty() && unavailPq.peek()[0] <= i) {
                val = unavailPq.poll();
                availPq.offer(new int[]{val[1], val[2]});
            }
            if (availPq.isEmpty()) {
                val = unavailPq.poll();
                t = val[0];
                res[i] = val[2];
                unavailPq.offer(new int[]{t+tasks[i], val[1], val[2]});
            } else {
                val = availPq.poll();
                res[i] = val[1];
                unavailPq.offer(new int[]{t+tasks[i], val[0], val[1]});
            }
        }

        return res;
    }
}